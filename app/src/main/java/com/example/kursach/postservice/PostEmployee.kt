package com.example.kursach.postservice

import android.util.Log
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.services.API
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostEmployee(
    private val employee: EmployeeBody
)
 {

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

        val call = myApi.sendEmployee(employee)
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