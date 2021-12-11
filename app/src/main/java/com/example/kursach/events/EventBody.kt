package com.example.kursach.events

data class EventBody(
    var idEvents: Int,
    var sport: String,
    var date: String,
    var time: String,
    var idSportClubs: Int
)
