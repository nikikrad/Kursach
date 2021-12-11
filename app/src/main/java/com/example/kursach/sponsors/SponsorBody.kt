package com.example.kursach.sponsors

import com.google.gson.annotations.SerializedName

data class SponsorBody(
    var idSponsors: Int,
    @SerializedName("sponsorName")
    var Name:String,
    @SerializedName("sponsorNumber")
    var Number: String,
    @SerializedName("sponsorMail")
    var Mail: String,
    var idSportClubs: Int
)
