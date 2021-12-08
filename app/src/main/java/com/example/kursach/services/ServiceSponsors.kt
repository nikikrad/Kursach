package com.example.kursach.services

import android.util.Log
import com.example.kursach.sponsors.Sponsor
import com.example.kursach.teams.Team
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceSponsors {

    var sponsorsList: MutableList<Sponsor> = emptyList<Sponsor>().toMutableList()
    private const val URL = "http://10.0.2.2:3000/"

    fun start(){

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.getAllSponsors()
        call.enqueue(object: Callback<List<Sponsor>> {

            override fun onResponse(
                call: Call<List<Sponsor>>,
                response: Response<List<Sponsor>>
            ) {
                if (response.isSuccessful){
                    if(response.isSuccessful) {
                        val sponsors = response.body()
                        if (sponsors != null) {
                            for (i in 0 until sponsors.count()) {
                                val idSponsors = sponsors[i].idSponsors
                                val name = sponsors[i].Name
                                val number = sponsors[i].Number
                                val mail = sponsors[i].Mail
                                val idSportClubs = sponsors[i].idSportClubs
                                sponsorsList.add(Sponsor(idSponsors, name, number, mail, idSportClubs))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Sponsor>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })

    }
}