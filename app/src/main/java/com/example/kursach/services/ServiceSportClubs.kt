package com.example.kursach.services

import android.util.Log
import com.example.kursach.clubs.Club
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceSportClubs {


    var clubsList: MutableList<Club> = emptyList<Club>().toMutableList()
    var processingAddress: MutableList<String> = emptyList<String>().toMutableList()

    private const val URL = "http://10.0.2.2:3000/"

    fun start(){
        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.getAllSportClubs()
        call.enqueue(object: Callback<List<Club>> {

            override fun onResponse(call: Call<List<Club>>, response: Response<List<Club>>) {
                if (response.isSuccessful){
                    Log.e("KEK", response.body().toString())
                    if(response.isSuccessful) {
                        val events = response.body()
                        if (events != null) {
                            for (i in 0 until events.count()) {
                                val id = events[i].idSportClubs
                                val address = events[i].sportAddress
                                processingAddress.add(address)
                                val number = events[i].sportNumber
                                val mail = events[i].sportMail
                                clubsList.add(Club(id, address, number, mail))
                                Log.e("KEK", ServiceEvents.eventsList.toString())
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Club>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }

        })
    }

}