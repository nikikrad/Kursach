package com.example.kursach.services

import com.example.kursach.clubs.Club
import com.example.kursach.dischs.Disch
import com.example.kursach.employees.Employee
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.events.Event
import com.example.kursach.kindofsports.KindOfSport
import com.example.kursach.players.Player
import com.example.kursach.positions.Position
import com.example.kursach.rolls.Roll
import com.example.kursach.sponsors.Sponsor
import com.example.kursach.teams.Team
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

   @GET("events")
   fun getAllEvents(): Call<List<Event>>

   @GET("sportclubs")
   fun getAllSportClubs(): Call<List<Club>>

   @GET("dischs")
   fun getAllDischs(): Call<List<Disch>>

   @GET("rolls")
   fun getAllRolls(): Call<List<Roll>>

   @GET("kindofsports")
   fun getAllKindOfSports(): Call<List<KindOfSport>>

   @GET("employees")
   fun getAllEmployees(): Call<List<Employee>>

   @GET("players")
   fun getAllPlayers(): Call<List<Player>>

   @GET("positions")
   fun getAllPositions(): Call<List<Position>>

   @GET("sponsors")
   fun getAllSponsors(): Call<List<Sponsor>>

   @GET("teams")
   fun getAllTeams(): Call<List<Team>>

   @POST("employees/create")
   fun sendEmployee(@Body employee: EmployeeBody): Call<EmployeeBody>

   @POST("positions/create")
   fun sendPosition(@Body position: Position): Call <Position>
}