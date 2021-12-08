package com.example.kursach.positions

import com.google.gson.annotations.SerializedName

data class Position(
    var idPositions: Int,
    @SerializedName("positionName")
    var Name: String
)
