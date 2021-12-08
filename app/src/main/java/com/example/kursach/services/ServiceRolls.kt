package com.example.kursach.services

import android.util.Log
import com.example.kursach.dischs.Disch
import com.example.kursach.rolls.Roll
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceRolls {

    var rollsList: MutableList<Roll> = emptyList<Roll>().toMutableList()
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

        val call = myApi.getAllRolls()
        call.enqueue(object: Callback<List<Roll>> {

            override fun onResponse(
                call: Call<List<Roll>>,
                response: Response<List<Roll>>
            ) {
                if (response.isSuccessful){
                    val rolls = response.body()
                    rollsList.clear()
                    rolls?.forEach{
                        rollsList.add(it)
                    }
                    Log.e("KEK", rollsList.toString())
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Roll>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}