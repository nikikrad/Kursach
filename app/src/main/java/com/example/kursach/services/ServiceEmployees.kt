package com.example.kursach.services

import android.util.Log
import com.example.kursach.employees.Employee
import com.example.kursach.players.Player
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceEmployees {

    var employeesList: MutableList<Employee> = emptyList<Employee>().toMutableList()
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

        val call = myApi.getAllEmployees()
        call.enqueue(object: Callback<List<Employee>> {

            override fun onResponse(
                call: Call<List<Employee>>,
                response: Response<List<Employee>>
            ) {
                if (response.isSuccessful){
                    if(response.isSuccessful) {
                        val employee = response.body()
                        if (employee != null) {
                            for (i in 0 until employee.count()) {
                                val idEmploees = employee[i].idEmploees
                                val name = employee[i].Name
                                val sername = employee[i].Surname
                                val lastname = employee[i].Lastname
                                val idPositions = employee[i].idPositions
                                val idSportClubs = employee[i].idSportClubs
                                employeesList.add(Employee(idEmploees, name, sername, lastname, idPositions, idSportClubs))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }
        })

    }
}