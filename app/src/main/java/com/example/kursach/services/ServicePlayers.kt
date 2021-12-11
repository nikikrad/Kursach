package com.example.kursach.services

import android.util.Log
import com.example.kursach.players.Player
import com.example.kursach.sponsors.Sponsor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServicePlayers {

    var playersList: MutableList<Player> = emptyList<Player>().toMutableList()
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

        val call = myApi.getAllPlayers()
        call.enqueue(object: Callback<List<Player>> {

            override fun onResponse(
                call: Call<List<Player>>,
                response: Response<List<Player>>
            ) {
                if (response.isSuccessful){
                    if(response.isSuccessful) {
                        val players = response.body()
                        if (players != null) {
                            for (i in 0 until players.count()) {
                                val idPlayers = players[i].idPlayers
                                val name = players[i].Name
                                val sername = players[i].Surname
                                val lastname = players[i].Lastname
                                val idDischs = players[i].idDischs
                                val idTeams = players[i].idTeams
                                val idKindOfSports = players[i].idKindOfSports

                                val idRolls = players[i].idRolls
                                playersList.add(Player(idPlayers, name, sername, lastname, idDischs, idTeams, idKindOfSports, idRolls))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Player>>, t: Throwable) {
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