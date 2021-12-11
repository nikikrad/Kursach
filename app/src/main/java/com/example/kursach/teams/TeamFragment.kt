package com.example.kursach.teams

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddTeamFragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentTeamBinding
import com.example.kursach.players.PlayerFragment
import com.example.kursach.players.PlayerFragment.Companion.TEAMLIST
import com.example.kursach.services.ServiceTeams
import com.example.kursach.services.ServiceTeams.teamsList

class TeamFragment: Fragment(){

    lateinit var binding: FragmentTeamBinding
//    lateinit var bundle: Bundle
//    val intent: Intent = Intent(context, PlayerFragment::class.java)

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


        var teamsAdapter = TeamsAdapter(teamsList,{ team -> teamClickListener(team) })
        binding.rvTeams.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvTeams.adapter = teamsAdapter

        binding.btnUpdate.setOnClickListener{

            teamsList.clear()
            ServiceTeams.start()
            binding.rvTeams.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvTeams.adapter = teamsAdapter
            Thread.sleep(500)
            (activity as? MainActivity)?.openFragment(TeamFragment())
        }

    }

    private fun teamClickListener(team: Team){

        Toast.makeText(context, team.toString(), Toast.LENGTH_SHORT).show()
        (activity as MainActivity).openFragment(PlayerFragment())
        PlayerFragment().setTeam(team)
//        bundle.putParcelableArrayList(TEAMLIST.toString(), team)
//        intent.putExtra(TEAMLIST, team)

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}