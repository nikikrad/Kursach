package com.example.kursach.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddTeamFragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentTeamBinding
import com.example.kursach.events.EventAdapter
import com.example.kursach.events.EventFragment
import com.example.kursach.services.ServiceEvents
import com.example.kursach.services.ServiceTeams
import com.example.kursach.services.ServiceTeams.teamsList

class TeamFragment: Fragment(){
//    lateinit var clickTeam: ClickTeam

    lateinit var binding: FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAddTeam.setOnClickListener {
            (activity as MainActivity).openFragment(AddTeamFragment())
        }


        val teamsAdapter = TeamsAdapter(teamsList)
        binding.rvTeams.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvTeams.adapter = teamsAdapter

        binding.btnUpdate.setOnClickListener{

            teamsList.clear()
            ServiceTeams.start()
            val teamsAdapter = TeamsAdapter(teamsList)
            binding.rvTeams.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvTeams.adapter = teamsAdapter
            Thread.sleep(500)
            (activity as? MainActivity)?.openFragment(TeamFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}