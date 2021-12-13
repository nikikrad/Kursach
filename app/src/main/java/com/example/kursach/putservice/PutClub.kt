package com.example.kursach.putservice

import android.util.Log
import com.example.kursach.clubs.Club
import com.example.kursach.events.EventBody
import com.example.kursach.services.API
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PutClub(
    var idSportClubs: Int,
    var sportAddress: String,
    var sportNumber: String,
    var sportMail: String
) {

    private  val URL = url

    fun start(){

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.updateClub(idSportClubs, sportAddress, sportNumber, sportMail)
        call.enqueue(object: Callback<Club> {

            override fun onResponse(
                call: Call<Club>,
                response: Response<Club>
            ) {
            }

            override fun onFailure(call: Call<Club>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })

    }
}