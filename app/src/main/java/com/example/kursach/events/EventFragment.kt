package com.example.kursach.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddEventFragment
import com.example.kursach.MainActivity
import com.example.kursach.WelcomeFragment.Companion.LOGGIN
import com.example.kursach.WelcomeFragment.Companion.PASSWORD
import com.example.kursach.databinding.FragmentEventBinding
import com.example.kursach.services.ServiceEvents
import com.example.kursach.services.ServiceEvents.eventID
import com.example.kursach.services.ServiceEvents.eventdate
import com.example.kursach.services.ServiceEvents.eventsList
import com.example.kursach.services.ServiceEvents.eventsport
import com.example.kursach.services.ServiceEvents.eventtime
import com.example.kursach.services.ServiceEvents.sportid

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

        if(LOGGIN == "admin" || PASSWORD == "admin"){
            binding.btnAddEvent.visibility = View.VISIBLE
        }else binding.btnAddEvent.visibility = View.GONE

        binding.btnAddEvent.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddEventFragment())
        }

        val eventAdapter = EventAdapter(eventsList)
        binding.rvEvent.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvEvent.adapter = eventAdapter

        binding.btnUpdate.setOnClickListener{

            eventsList.clear()
            eventID.clear()
            eventsport.clear()
            eventdate.clear()
            eventtime.clear()
            sportid.clear()

            ServiceEvents.start()
            val eventAdapter = EventAdapter(eventsList)
            binding.rvEvent.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvEvent.adapter = eventAdapter
            Thread.sleep(500)
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}