package com.example.kursach.events

import com.google.gson.annotations.SerializedName
import java.net.Inet4Address

data class Event(
    @SerializedName("id")
    var idEvents: Int,
    var sport: String,
    var date: String,
    var time: String,
    var idSportClubs: Int,
//    @SerializedName("sportAddress")
    var address: String
    )
