package com.example.kursach.services

import android.util.Log
import com.example.kursach.employees.Employee
import com.example.kursach.players.Player
import com.example.kursach.services.URL.url
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceEmployees {


    var employeesList: MutableList<Employee> = emptyList<Employee>().toMutableList()
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
                                val position = positionsInfo(idPositions)
                                val idSportClubs = employee[i].idSportClubs
                                val address = clubAddress(idSportClubs)
                                employeesList.add(Employee(idEmploees, name, sername, lastname, idPositions, idSportClubs, address, position))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
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

            fun positionsInfo(idPosition: Int): String{

                var tempClub = ServicePositions.positionsList

                tempClub.forEach {
                    if (it.idPositions == idPosition){
                        return it.Name
                    }
                }
                return "null"
            }
        })

    }
}