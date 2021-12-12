package com.example.kursach.players

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddTeamFragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.addfragments.AddEventFragment
import com.example.kursach.addfragments.AddPlayersFragment
import com.example.kursach.addfragments.AddRollFragment
import com.example.kursach.databinding.FragmentPlayersBinding
import com.example.kursach.services.ServiceDischs
import com.example.kursach.services.ServiceKindOfSports
import com.example.kursach.services.ServicePlayers
import com.example.kursach.services.ServicePlayers.playersList
import com.example.kursach.services.ServiceRolls
import com.example.kursach.teams.Team
import com.example.kursach.teams.TeamFragment

class PlayerFragment(var team: Team): Fragment() {

    lateinit var binding: FragmentPlayersBinding

    var teamNaming = team
//    private var definityTeam: MutableList<Player> = emptyList<Player>().toMutableList()
//    private var team: Team? = null
    lateinit var variableTeam: Team

    //var TEAMLIST: Team? = null
    var idTeam: Int = teamNaming.idTeams
    //var idTeam: Int = TEAMLIST!!.idTeams
    companion object{
        //var TEAMLIST: Team? = null
//        = TeamFragment.TeamName
        var definityTeam: MutableList<Player> = emptyList<Player>().toMutableList()
       // var idTeam: Int = TEAMLIST.idTeams
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayersBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAddPlayer.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddPlayersFragment(teamNaming))
        }
        binding.btnRoll.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddRollFragment())
        }

        binding.tvNameTeam.setText(teamNaming.teamName)

        definityTeam.clear()
        playersList.forEach{
            if(it.idTeams == teamNaming.idTeams){
                definityTeam.add(Player(0,it.Name, it.Surname, it.Lastname, it.idDischs, it.DischName, it.idTeams, it.TeamName, it.idKindOfSports, it.SportName, it.idRolls, it.RollName))
            }
        }

        val playerAdapter = PlayerAdapter(definityTeam)
        binding.rvPlayer.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvPlayer.adapter = playerAdapter

        binding.btnUpdate.setOnClickListener {
            definityTeam.clear()
            playersList.clear()
            ServicePlayers.start()
            binding.rvPlayer.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvPlayer.adapter = playerAdapter
            Thread.sleep(500)
            (activity as? MainActivity)?.openFragment(PlayerFragment(teamNaming))
        }


    }

//    fun setTeam(team: Team){
//        this.team = team
//        TEAMLIST = team
//    }





    override fun onDestroy() {
        super.onDestroy()
    }
}