package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.databinding.FragmentEventBinding

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

        var eventList = listOf(
            Event("Футбол","19.12.2000","19:30"),
            Event("Гандбол","12.08.2341","19:30"),
            Event("Волейбол","16.11.2020","19:30"),
            Event("Футбол","19.12.2000","19:30"),
            Event("Хоккей","29.04.2200","19:30"),
            Event("Вилей","19.02.2031","19:30"),
            Event("Жокей","18.11.1941","19:30"),

        )

        val eventAdapter = EventAdapter(eventList)
        binding.rvEvent.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvEvent.adapter = eventAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}