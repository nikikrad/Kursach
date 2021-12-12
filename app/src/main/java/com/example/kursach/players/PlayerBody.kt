package com.example.kursach.players

import com.google.gson.annotations.SerializedName

data class PlayerBody(
    var idPlayers: Int,
    var pFirstName: String,
    var pSurName: String,
    var pLastName: String,
    var idDischs: Int,
    var idTeams: Int,
    var idKindOfSports: Int,
    var idRolls: Int
)
