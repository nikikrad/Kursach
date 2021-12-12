package com.example.kursach.services

import android.util.Log
import com.example.kursach.players.PlayerBody
import com.example.kursach.positions.Position
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostPlayer (
    private var player: PlayerBody
    ){

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

        val call = myApi.sendPlayer(player)
        call.enqueue(object: Callback<PlayerBody> {

            override fun onResponse(
                call: Call<PlayerBody>,
                response: Response<PlayerBody>
            ) {
            }

            override fun onFailure(call: Call<PlayerBody>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })

    }
}