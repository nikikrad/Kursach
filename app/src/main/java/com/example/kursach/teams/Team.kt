package com.example.kursach.teams

import com.google.gson.annotations.SerializedName

data class Team(
    var idTeams: Int,
    @SerializedName("teamName")
    var Name: String,
    var idSportClubs: Int
    )