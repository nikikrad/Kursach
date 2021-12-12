package com.example.kursach.services

import android.util.Log
import com.example.kursach.employees.Employee
import com.example.kursach.positions.Position
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServicePositions {

    var positionsList: MutableList<Position> = emptyList<Position>().toMutableList()
    var idPositionsList: MutableList<Int> = emptyList<Int>().toMutableList()
    var positionsNameList: MutableList<String> = emptyList<String>().toMutableList()

    private val URL = url

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
                    if (positions != null) {
                        for (i in 0 until positions.count()) {
                            val idPositions = positions[i].idPositions
                            idPositionsList.add(idPositions)
                            val name = positions[i].Name
                            positionsNameList.add(name)
                            positionsList.add(Position(idPositions, name))
                        }
                    }
//                    positionsList.clear()
//                    positions?.forEach{
//                        positionsList.add(it)
//                    }
                    Log.e("KEK", positionsList.toString())
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Position>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}