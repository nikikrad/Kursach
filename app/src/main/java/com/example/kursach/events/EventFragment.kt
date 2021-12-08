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
import com.example.kursach.services.ServiceEvents
import com.example.kursach.services.ServiceEvents.eventsList

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

        val eventAdapter = EventAdapter(eventsList)
        binding.rvEvent.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvEvent.adapter = eventAdapter

        binding.btnUpdate.setOnClickListener{

            eventsList.clear()
            ServiceEvents.start()
            val eventAdapter = EventAdapter(eventsList)
            binding.rvEvent.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvEvent.adapter = eventAdapter
            Thread.sleep(1000)
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}