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

   @FormUrlEncoded
   @PUT("events/update/{id}")
   fun updateEvent(
      @Path("id") id: Int,
      @Field("sport") sport: String,
      @Field("date") date: String,
      @Field("time") time: String,
      @Field("idSportClubs") idSportClubs: Int
   ):Call<EventBody>

   @FormUrlEncoded
   @PUT("sportclubs/update/{id}")
   fun updateClub(
      @Path("id") id: Int,
      @Field("sportAddress") sportAddress: String,
      @Field("sportNumber") sportNumber: String,
      @Field("sportMail") sportMail: String
   ):Call<Club>

   @FormUrlEncoded
   @PUT("rolls/update/{id}")
   fun   updateRoll(
      @Path("id") id: Int,
      @Field("roll") roll: String,
   ): Call<Roll>

   @DELETE("rolls/delete/{id}")
   fun deleteRoll(
      @Path("id") id: Int
   ):Call<Unit>

   @DELETE("players/delete/{id}")
   fun deletePlayer(
      @Path("id") id: Int
   ):Call<Unit>

   @DELETE("teams/delete/{id}")
   fun deleteTeam(
      @Path("id") id: Int
   ):Call<Unit>

   @DELETE("sportclubs/delete/{id}")
   fun deleteClub(
      @Path("id") id: Int
   ):Call<Unit>

   @DELETE("sponsors/delete/{id}")
   fun deleteSponsor(
      @Path("id") id: Int
   ):Call<Unit>

   @DELETE("employees/delete/{id}")
   fun deleteEmployee(
      @Path("id") id: Int
   ):Call<Unit>

   @DELETE("positions/delete/{id}")
   fun deletePosition(
      @Path("id") id: Int
   ):Call<Unit>

   @DELETE("events/delete/{id}")
   fun deleteEvent(
      @Path("id") id: Int
   ):Call<Unit>

}