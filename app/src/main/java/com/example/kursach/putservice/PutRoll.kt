package com.example.kursach.putservice

import android.util.Log
import com.example.kursach.events.EventBody
import com.example.kursach.rolls.Roll
import com.example.kursach.services.API
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PutRoll(
    var idRolls: Int,
    var roll: String
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

        val call = myApi.updateRoll(idRolls, roll)
        call.enqueue(object: Callback<Roll> {

            override fun onResponse(
                call: Call<Roll>,
                response: Response<Roll>
            ) {
            }

            override fun onFailure(call: Call<Roll>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })

    }

}