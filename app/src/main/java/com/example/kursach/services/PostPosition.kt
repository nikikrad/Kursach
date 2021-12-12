package com.example.kursach.services

import android.util.Log
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.positions.Position
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostPosition(
    private var position: Position
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

        val call = myApi.sendPosition(position)
        call.enqueue(object: Callback<Position> {

            override fun onResponse(
                call: Call<Position>,
                response: Response<Position>
            ) {
            }

            override fun onFailure(call: Call<Position>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })

    }
}