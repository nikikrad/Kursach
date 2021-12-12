package com.example.kursach.kindofsports

import com.google.gson.annotations.SerializedName

data class KindOfSport(
    var idKindOfSports: Int,
    @SerializedName("kindofsport")
    var KindOfSports: String
)
