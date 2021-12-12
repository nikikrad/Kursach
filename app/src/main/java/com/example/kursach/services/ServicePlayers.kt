package com.example.kursach.services

import android.util.Log
import com.example.kursach.players.Player
import com.example.kursach.services.URL.url
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
    var playerName: MutableList<String> = emptyList<String>().toMutableList()
    var playerSurname: MutableList<String> = emptyList<String>().toMutableList()
    var playerLastname: MutableList<String> = emptyList<String>().toMutableList()
    var numberTeam: MutableList<Int> = emptyList<Int>().toMutableList()

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
                                playerName.add(name)
                                val surname = players[i].Surname
                                playerSurname.add(surname)
                                val lastname = players[i].Lastname
                                playerLastname.add(lastname)
                                val idDischs = players[i].idDischs
                                val disch = dischName(idDischs)
                                val idTeams = players[i].idTeams
                                numberTeam.add(idTeams)
                                val team = teamName(idTeams)
                                val idKindOfSports = players[i].idKindOfSports
                                val kindofsport = sportName(idKindOfSports)
                                val idRolls = players[i].idRolls
                                val roll = rollName(idRolls)
                                playersList.add(Player(idPlayers, name, surname, lastname, idDischs, disch, idTeams, team, idKindOfSports, kindofsport, idRolls, roll))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Player>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }

            fun dischName(idDisch: Int): String{

                var tempDisch = ServiceDischs.dischsList

                tempDisch.forEach {
                    if (it.idDischs == idDisch){
                        return it.disch
                    }
                }
                return "null"
            }

            fun teamName(idTeam: Int): String{

                var tempTeam = ServiceTeams.teamsList

                tempTeam.forEach {
                    if (it.idTeams == idTeam){
                        return it.teamName
                    }
                }
                return "null"
            }

            fun sportName(idSport: Int): String{

                var tempSport = ServiceKindOfSports.kindofsportsList

                tempSport.forEach {
                    if (it.idKindOfSports == idSport){
                        return it.KindOfSports
                    }
                }
                return "null"
            }

            fun rollName(idRoll: Int): String{

                var tempRoll = ServiceRolls.rollsList

                tempRoll.forEach {
                    if (it.idRolls == idRoll){
                        return it.roll
                    }
                }
                return "null"
            }

        })

    }
}