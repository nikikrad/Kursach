package com.example.kursach.teams

import com.google.gson.annotations.SerializedName

data class Team(
    var idTeams: Int,
//    @SerializedName("teamName")
    var teamName: String,
    var idSportClubs: Int,
    var address: String
    )