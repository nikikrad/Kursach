package com.example.kursach.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddEventFragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentEventBinding
import com.example.kursach.test.Service
import com.example.kursach.test.Service.eventsList
import com.example.kursach.test.ServiceSportClubs
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class EventFragment: Fragment() {

    lateinit var binding: FragmentEventBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAddEvent.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddEventFragment())
        }

//        val url = "jdbc:mysql://localhost:3000/events"
//        val username = "root"
//        val password = "denis"
//        var connection: Connection? = null

//        try {
//            Class.forName("com.mysql.jdbc.Driver")
//            connection = DriverManager.getConnection(url, username, password)
//
//        } catch (e: Exception) {
//        }

//        var eventList = listOf(
//            Event("Футбол","19.12.2000","19:30"),
//            Event("Гандбол","12.08.2341","19:30"),
//            Event("Волейбол","16.11.2020","19:30"),
//            Event("Футбол","19.12.2000","19:30"),
//            Event("Хоккей","29.04.2200","19:30"),
//            Event("Вилей","19.02.2031","19:30"),
//            Event("Война","22.06.1941","19:30"),
//
//        )

//        eventsList.clear()
//        Service.start()
        val eventAdapter = EventAdapter(eventsList)
        binding.rvEvent.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvEvent.adapter = eventAdapter

        binding.btnUpdate.setOnClickListener{

            eventsList.clear()
            Service.start()
            val eventAdapter = EventAdapter(eventsList)
            binding.rvEvent.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvEvent.adapter = eventAdapter
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}