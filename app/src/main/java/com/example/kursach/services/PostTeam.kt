package com.example.kursach.services

import android.util.Log
import com.example.kursach.positions.Position
import com.example.kursach.teams.Team
import com.example.kursach.teams.TeamBody
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostTeam(
    private var team: TeamBody
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

        val call = myApi.sendTeam(team)
        call.enqueue(object: Callback<TeamBody> {

            override fun onResponse(
                call: Call<TeamBody>,
                response: Response<TeamBody>
            ) {
            }

            override fun onFailure(call: Call<TeamBody>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })
    }
}