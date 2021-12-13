package com.example.kursach.services

import com.example.kursach.clubs.Club
import com.example.kursach.dischs.Disch
import com.example.kursach.employees.Employee
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.events.Event
import com.example.kursach.events.EventBody
import com.example.kursach.kindofsports.KindOfSport
import com.example.kursach.players.Player
import com.example.kursach.players.PlayerBody
import com.example.kursach.positions.Position
import com.example.kursach.rolls.Roll
import com.example.kursach.sponsors.Sponsor
import com.example.kursach.sponsors.SponsorBody
import com.example.kursach.teams.Team
import com.example.kursach.teams.TeamBody
import retrofit2.Call
import retrofit2.http.*

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

   @POST("sponsors/create")
   fun sendSponsor(@Body sponsor: SponsorBody): Call <SponsorBody>

   @POST("sportclubs/create")
   fun sendSportClub(@Body clubs: Club): Call <Club>

   @POST("events/create")
   fun sendEvent(@Body event: EventBody): Call <EventBody>

   @POST("teams/create")
   fun sendTeam(@Body team: TeamBody): Call <TeamBody>

   @POST("players/create")
   fun sendPlayer(@Body player: PlayerBody): Call <PlayerBody>

   @POST("rolls/create")
   fun sendRoll(@Body roll: Roll): Call <Roll>

   @POST("dischs/create")
   fun sendDisch(@Body disch: Disch): Call <Disch>

   @POST("kindofsports/create")
   fun sendKindOfSport(@Body kindofsport: KindOfSport): Call <KindOfSport>

   @FormUrlEncoded
   @PUT("positions/update/{id}")
   fun   updatePosition(
      @Path("id") id: Int,
      @Field("positionName") Name: String
   ): Call<Position>

   @FormUrlEncoded
   @PUT("players/update/{id}")
   fun updatePlayer(
      @Path("id") id: Int,
      @Field("pFirstName") pFirstName: String,
      @Field("pSurName") pSurName: String,
      @Field("pLastName") pLastName: String,
      @Field("idDischs") idDischs: Int,
      @Field("idTeams") idTeams: Int,
      @Field("idKindOfSports") idKindOfSports: Int,
      @Field("idRolls") idRolls: Int
   ):Call<PlayerBody>

   @FormUrlEncoded
   @PUT("employees/update/{id}")
   fun updateEmployee(
      @Path("id") id: Int,
      @Field("eFirstName") eFirstName: String,
      @Field("eSurName") eSurName: String,
      @Field("eLastName") eLastName: String,
      @Field("idPositions") idPositions: Int,
      @Field("idSportClubs") idSportClubs: Int
   ):Call<EmployeeBody>

   @FormUrlEncoded
   @PUT("sponsors/update/{id}")
   fun updateSponsor(
      @Path("id") id: Int,
      @Field("sponsorName") sponsorName: String,
      @Field("sponsorNumber") sponsorNumber: String,
      @Field("sponsorMail") sponsorMail: String,
      @Field("idSportClubs") idSportClubs: Int
   ):Call<SponsorBody>

   @FormUrlEncoded
   @PUT("teams/update/{id}")
   fun   updateTeam(
      @Path("id") id: Int,
      @Field("teamName") Name: String,
      @Field("idSportClubs") idSportClubs: Int
   ): Call<TeamBody>
}