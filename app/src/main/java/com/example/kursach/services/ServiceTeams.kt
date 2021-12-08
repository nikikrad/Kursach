package com.example.kursach.services

import android.util.Log
import com.example.kursach.teams.Team
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceTeams {

    var teamsList: MutableList<Team> = emptyList<Team>().toMutableList()
    private const val URL = "http://10.0.2.2:3000/"

    fun start(){

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.getAllTeams()
        call.enqueue(object: Callback<List<Team>> {

            override fun onResponse(
                call: Call<List<Team>>,
                response: Response<List<Team>>
            ) {
                if (response.isSuccessful){
                    if(response.isSuccessful) {
                        val teams = response.body()
                        if (teams != null) {
                            for (i in 0 until teams.count()) {
                                val idTeams = teams[i].idTeams
                                val name = teams[i].Name
                                val club = teams[i].idSportClubs
                                teamsList.add(Team(idTeams, name, club))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })

    }
}