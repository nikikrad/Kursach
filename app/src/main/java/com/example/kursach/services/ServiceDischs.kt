package com.example.kursach.services

import android.util.Log
import com.example.kursach.dischs.Disch
import com.example.kursach.kindofsports.KindOfSport
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceDischs {

    var dischsList: MutableList<Disch> = emptyList<Disch>().toMutableList()
    var iddisch: MutableList<Int> = emptyList<Int>().toMutableList()
    var disch: MutableList<String> = emptyList<String>().toMutableList()


    private const val URL = "http://10.0.2.2:3000/"

    fun start() {

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.getAllDischs()
        call.enqueue(object: Callback<List<Disch>> {

            override fun onResponse(
                call: Call<List<Disch>>,
                response: Response<List<Disch>>
            ) {
                if (response.isSuccessful){
                    val dischs = response.body()
                    if (dischs != null) {
                        for (i in 0 until dischs.count()) {
                            val id = dischs[i].idDischs
                            iddisch.add(id)
                            val dischName = dischs[i].disch
                            disch.add(dischName)
                            dischsList.add(Disch(id, dischName))
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Disch>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}