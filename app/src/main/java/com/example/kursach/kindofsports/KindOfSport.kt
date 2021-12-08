package com.example.kursach.kindofsports

import com.google.gson.annotations.SerializedName

data class KindOfSport(
    var idKindOfSport: String,
    @SerializedName("kindofsport")
    var KindOfSports: String
)
