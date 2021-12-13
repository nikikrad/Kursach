package com.example.kursach.services

import android.icu.number.NumberRangeFormatter
import android.util.Log
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.sponsors.SponsorBody
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PutSponsor(
    var ID: Int,
    var name: String,
    var number: String,
    var mail: String,
    var sportID: Int
) {
    private val URL = com.example.kursach.services.URL.url

//    var sponsorID = ID
//    var NAME = name
//    var NUMBER = number
//    var MAIL = mail
//    var SPORTid = sportID


    fun start() {

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.updateSponsor(ID, name, number, mail, sportID)
        call.enqueue(object: Callback<SponsorBody> {

            override fun onResponse(
                call: Call<SponsorBody>,
                response: Response<SponsorBody>
            ) {

            }

            override fun onFailure(call: Call<SponsorBody>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}