package com.example.kursach.employees

import com.google.gson.annotations.SerializedName

data class Employee(
    var idEmploees: Int,
    @SerializedName("eFirtName")
    var Name: String,
    @SerializedName("eSurName")
    var Surname: String,
    @SerializedName("eLastName")
    var Lastname:String,
    var idPositions: Int,
    var idSportClubs: Int
    )
