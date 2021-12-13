package com.example.kursach.services

import android.util.Log
import com.example.kursach.services.URL.url
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
    var nameSponsors: MutableList<String> = emptyList<String>().toMutableList()
    var sponsorID: MutableList<Int> = emptyList<Int>().toMutableList()
    private  val URL = url

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
                                sponsorID.add(idSponsors)
                                val name = sponsors[i].Name
                                nameSponsors.add(name)
                                val number = sponsors[i].Number
                                val mail = sponsors[i].Mail
                                val idSportClubs = sponsors[i].idSportClubs
                                val address = clubAddress(idSportClubs)
                                sponsorsList.add(Sponsor(idSponsors, name, number, mail, idSportClubs, address))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Sponsor>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }

            fun clubAddress(idClub: Int): String{

                var tempClub = ServiceSportClubs.clubsList

                tempClub.forEach {
                    if (it.idSportClubs == idClub){
                        return it.sportAddress
                    }
                }
                return "null"
            }

        })

    }
}