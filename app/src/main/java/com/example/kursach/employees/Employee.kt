package com.example.kursach.employees

import com.google.gson.annotations.SerializedName

data class Employee(
    var idEmployees: Int,
    @SerializedName("eFirstName")
    var Name: String,
    @SerializedName("eSurName")
    var Surname: String,
    @SerializedName("eLastName")
    var Lastname:String,
    var idPositions: Int,
    var idSportClubs: Int,
    var address: String,
    var positions: String
    )
