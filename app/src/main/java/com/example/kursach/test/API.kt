package com.example.kursach.test

import com.example.kursach.clubs.Club
import com.example.kursach.events.Event
import retrofit2.Call
import retrofit2.http.GET

interface API {

   @GET("events")
   fun getAllEvents(): Call<List<Event>>

   @GET("sportclubs")
   fun getAllSportClubs(): Call<List<Club>>


}