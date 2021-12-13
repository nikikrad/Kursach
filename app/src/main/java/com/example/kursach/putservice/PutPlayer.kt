package com.example.kursach.putservice

import android.util.Log
import com.example.kursach.players.PlayerBody
import com.example.kursach.services.API
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PutPlayer(
    var id: Int,
    var name: String,
    var surname: String,
    var lastname: String,
    var disch: Int,
    var team: Int,
    var kindofsport: Int,
    var roll: Int
) {

//    var position: Position = Position(ID, positionname)

    private val URL = url
    var ID = id
    var imya = name
    var familiya = surname
    var otchestvo = lastname
    var razryad = disch
    var komanda = team
    var vidsporta = kindofsport
    var roli = roll

    fun start() {

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(API::class.java)

        val call = myApi.updatePlayer(ID, imya, familiya, otchestvo, razryad, komanda, vidsporta, roli)
        call.enqueue(object: Callback<PlayerBody> {

            override fun onResponse(
                call: Call<PlayerBody>,
                response: Response<PlayerBody>
            ) {

            }

            override fun onFailure(call: Call<PlayerBody>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })
    }
}