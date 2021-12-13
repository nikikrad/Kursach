package com.example.kursach.services

import android.util.Log
import com.example.kursach.events.Event
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceEvents {

    var eventsList: MutableList<Event> = emptyList<Event>().toMutableList()
    var eventID: MutableList<Int> = emptyList<Int>().toMutableList()
    var eventsport: MutableList<String> = emptyList<String>().toMutableList()
    var eventdate: MutableList<String> = emptyList<String>().toMutableList()
    var eventtime: MutableList<String> = emptyList<String>().toMutableList()
    var sportid: MutableList<Int> = emptyList<Int>().toMutableList()


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

        val call = myApi.getAllEvents()
        call.enqueue(object: Callback<List<Event>>{

            override fun onResponse(
                call: Call<List<Event>>,
                response: Response<List<Event>>
            ) {
                if (response.isSuccessful){
//                    Log.e("KEK", response.body().toString())
                    if(response.isSuccessful) {
                        val events = response.body()
                        if (events != null) {
                            for (i in 0 until events.count()) {
                                val idEvents = events[i].idEvents
                                eventID.add(idEvents)
                                val sport = events[i].sport
                                eventsport.add(sport)
                                val date = events[i].date
                                eventdate.add(date)
                                val time = events[i].time
                                eventtime.add(time)
                                val idSportClubs = events[i].idSportClubs
                                val address = clubAddress(idSportClubs)
                                eventsList.add(Event(idEvents, sport, date, time, idSportClubs, address))
//                                Log.e("KEK", eventsList.toString())
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


            fun clubAddress(idClub: Int): String{

                var tempClub = ServiceSportClubs.clubsList

                var buf: MutableList<Int> = emptyList<Int>().toMutableList()


                tempClub.forEach {
                    if (it.idSportClubs == idClub){
                        return it.sportAddress
                    }
                }
                Log.e("KEK", buf.toString())


                return "null"
            }
        })

    }

}