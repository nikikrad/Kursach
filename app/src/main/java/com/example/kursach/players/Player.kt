package com.example.kursach.players

import com.google.gson.annotations.SerializedName

data class Player(
        var idPlayers: Int,
        @SerializedName("pFirstName")
        var Name: String,
        @SerializedName("pSurName")
        var Surname: String,
        @SerializedName("pLastName")
        var Lastname: String,
        var idDischs: Int,
        var idTeams: Int,
        var idKindOfSports: Int,
        var idRolls: Int
)
