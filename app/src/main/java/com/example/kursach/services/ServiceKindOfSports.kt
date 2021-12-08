package com.example.kursach.services

import android.util.Log
import com.example.kursach.kindofsports.KindOfSport
import com.example.kursach.positions.Position
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceKindOfSports {

    var kindofsportsList: MutableList<KindOfSport> = emptyList<KindOfSport>().toMutableList()
    private const val URL = "http://10.0.2.2:3000/"

    fun start() {

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.getAllKindOfSports()
        call.enqueue(object: Callback<List<KindOfSport>> {

            override fun onResponse(
                call: Call<List<KindOfSport>>,
                response: Response<List<KindOfSport>>
            ) {
                if (response.isSuccessful){
                    val sports = response.body()
                    kindofsportsList.clear()
                    sports?.forEach{
                        kindofsportsList.add(it)
                    }
                    Log.e("KEK", kindofsportsList.toString())
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<KindOfSport>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}