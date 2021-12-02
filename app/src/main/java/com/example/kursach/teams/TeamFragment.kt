package com.example.kursach.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddTeamFragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentTeamBinding

class TeamFragment: Fragment(){

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

        var workerList = listOf(
            Teams("Liqued"),
            Teams("VP"),
            Teams("NAVI"),
            Teams("Evil Genius"),
            Teams("OG"),
            Teams("Invictus Game")
        )

        val teamAdapter = TeamsAdapter(workerList)
        binding.rvTeams.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvTeams.adapter = teamAdapter



    }

    override fun onDestroy() {
        super.onDestroy()
    }
}