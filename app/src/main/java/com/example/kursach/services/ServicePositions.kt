package com.example.kursach.services

import android.util.Log
import com.example.kursach.positions.Position
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServicePositions {

    var positionsList: MutableList<Position> = emptyList<Position>().toMutableList()
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

        val call = myApi.getAllPositions()
        call.enqueue(object: Callback<List<Position>>{

            override fun onResponse(
                call: Call<List<Position>>,
                response: Response<List<Position>>
            ) {
                if (response.isSuccessful){
                    val positions = response.body()
                    positionsList.clear()
                    positions?.forEach{
                        positionsList.add(it)
                    }
                    Log.e("KEK", positionsList.toString())
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Position>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}