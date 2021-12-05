package com.example.kursach.test

import android.util.Log
import com.example.kursach.events.Event
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object supportevents {

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

        val call = myApi.getAllEvents()
        call.enqueue(object: Callback<List<Event>> {

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if (response.isSuccessful){
                    Log.e("KEK", response.body().toString())
                    if(response.isSuccessful) {
                        val events = response.body()
                        if (events != null) {
                            for (i in 0 until events.count()) {
                                val idEvents = events[i].idEvents
                                val sport = events[i].sport
                                val date = events[i].date
                                val time = events[i].time
                                val idSportClubs = events[i].idSportClubs
                                val address = events[i].address
                                Service.eventsList.add(Event(idEvents, sport, date, time, idSportClubs, address))
                                Log.e("KEK", Service.eventsList.toString())
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }

}