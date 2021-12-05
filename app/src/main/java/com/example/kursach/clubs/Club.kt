package com.example.kursach.clubs

import com.google.gson.annotations.SerializedName

data class Club(
    @SerializedName("id")
    var idSportClubs: Int,
    var sportAddress: String,
    var sportNumber: String,
    var sportMail: String
)
