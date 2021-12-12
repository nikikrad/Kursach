package com.example.kursach.players

data class PlayerForAdapter(
    var Name:MutableList<String> = emptyList<String>().toMutableList(),
    var Surname: MutableList<String> = emptyList<String>().toMutableList(),
    var Lastname: MutableList<String> = emptyList<String>().toMutableList()
)
