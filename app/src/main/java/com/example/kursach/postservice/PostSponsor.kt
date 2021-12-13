package com.example.kursach.postservice

import android.util.Log
import com.example.kursach.services.API
import com.example.kursach.services.URL.url
import com.example.kursach.sponsors.SponsorBody
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostSponsor(
    private var sponsor: SponsorBody
) {


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

        val call = myApi.sendSponsor(sponsor)
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