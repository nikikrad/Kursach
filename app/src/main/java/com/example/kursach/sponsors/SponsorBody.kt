package com.example.kursach.sponsors

import com.google.gson.annotations.SerializedName

data class SponsorBody(
    var idSponsors: Int,
    var sponsorName:String,
    var sponsorNumber: String,
    var sponsorMail: String,
    var idSportClubs: Int
)
