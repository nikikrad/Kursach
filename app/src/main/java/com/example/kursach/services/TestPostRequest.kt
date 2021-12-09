package com.example.kursach.services

import android.util.Log
import com.example.kursach.employees.Employee
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.sponsors.Sponsor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TestPostRequest
//    private val employee: EmployeeBody
 {

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

        val call = myApi.sendEmployee(EmployeeBody(0,"Nikita", "Maruev", "Sinyagin", 1, 2))
        call.enqueue(object: Callback<EmployeeBody> {

            override fun onResponse(
                call: Call<EmployeeBody>,
                response: Response<EmployeeBody>
            ) {
            }

            override fun onFailure(call: Call<EmployeeBody>, t: Throwable) {
                Log.e("KEK", t.toString())
            }


        })

    }
}