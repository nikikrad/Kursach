package com.example.kursach.services

import android.util.Log
import com.example.kursach.dischs.Disch
import com.example.kursach.positions.Position
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
    var idroll: MutableList<Int> = emptyList<Int>().toMutableList()
    var roll: MutableList<String> = emptyList<String>().toMutableList()
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
                    if (rolls != null) {
                        for (i in 0 until rolls.count()) {
                            val idRolls = rolls[i].idRolls
                            idroll.add(idRolls)
                            val rollname = rolls[i].roll
                            roll.add(rollname)
                            rollsList.add(Roll(idRolls, rollname))
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Roll>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}