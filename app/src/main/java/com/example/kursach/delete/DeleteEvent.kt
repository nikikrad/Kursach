package com.example.kursach.delete

import android.util.Log
import com.example.kursach.services.API
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DeleteEvent(
    var ID: Int
) {

    private  val URL = com.example.kursach.services.URL.url

    fun start(){

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.deleteEvent(ID)
        call.enqueue(object: Callback<Unit> {

            override fun onResponse(
                call: Call<Unit>,
                response: Response<Unit>
            ) {
                if (response.isSuccessful)
                    Log.e("qwerty", "WORK")
                else
                    Log.e("qwerty", "DOSENT WORK")
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })

    }

}