package com.example.kursach.services

import android.util.Log
import com.example.kursach.services.URL.url
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
    var teamID: MutableList<Int> = emptyList<Int>().toMutableList()
    var teamName: MutableList<String> = emptyList<String>().toMutableList()
    private val URL = url

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
                                teamID.add(idTeams)
                                val name = teams[i].teamName
                                teamName.add(name)
                                val club = teams[i].idSportClubs
                                val address = clubAddress(club)
                                teamsList.add(Team(idTeams, name, club, address))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }

            fun clubAddress(idClub: Int): String{

                var tempClub = ServiceSportClubs.clubsList

                tempClub.forEach {
                    if (it.idSportClubs == idClub){
                        return it.sportAddress
                    }
                }
                return "null"
            }

        })

    }
}