package com.example.kursach.services

import android.util.Log
import com.example.kursach.clubs.Club
import com.example.kursach.events.EventBody
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostEvent(
    private var event: EventBody
) {
    private  val URL = "http://10.0.2.2:3000/"

    fun start(){

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.sendEvent(event)
        call.enqueue(object: Callback<EventBody> {

            override fun onResponse(
                call: Call<EventBody>,
                response: Response<EventBody>
            ) {
            }

            override fun onFailure(call: Call<EventBody>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })

    }
}