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

class PutPlayer(
    var name: String,
    var surname: String,
    var lastname: String,
    var disch: Int,
    var team: Int,
    var kindofsport: Int,
    var roll: Int
) {

//    var position: Position = Position(ID, positionname)

    private val URL = com.example.kursach.services.URL.url

    var Name = name
    var Surname = surname
    var Lastname = lastname
    var Disch = disch
    var Team = team
    var Kindofsport = kindofsport
    var Roll = roll

    fun start() {

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.updatePosition(id, position)
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