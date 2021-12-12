package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddplayersBinding
import com.example.kursach.databinding.FragmentAddpositionBinding
import com.example.kursach.employees.EmployeeFragment
import com.example.kursach.players.PlayerForAdapter
import com.example.kursach.services.*
import com.example.kursach.services.ServiceDischs.dischsList
import com.example.kursach.services.ServicePlayers.numberTeam
import com.example.kursach.services.ServicePlayers.playerID
import com.example.kursach.services.ServicePlayers.playerLastname
import com.example.kursach.services.ServicePlayers.playerName
import com.example.kursach.services.ServicePlayers.playerSurname
import com.example.kursach.services.ServicePlayers.playersList
import com.example.kursach.teams.Team

class PutPlayerFragment(var team: Team): Fragment() {

    lateinit var binding: FragmentAddplayersBinding
    var teamNumb = team

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddplayersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {
//            assemblyPosition()
            ServicePositions.positionsList.clear()
            ServicePositions.positionsNameList.clear()
            ServicePositions.start()
            (activity as? MainActivity)?.openFragment(EmployeeFragment())
        }


        setTextInputLayout()

    }

    var player: MutableList<String> = emptyList<String>().toMutableList()
    var playerid: MutableList<Int> = emptyList<Int>().toMutableList()

    fun setTextInputLayout() {

        ServicePositions.positionsNameList.clear()
        ServicePositions.start()

//        var player: MutableList<PlayerForAdapter> = emptyList<PlayerForAdapter>().toMutableList()
//        player.add(PlayerForAdapter(playerName, playerSurname, playerLastname))
        var i = 0

        playerName.forEach{
            if (numberTeam[i] == teamNumb.idTeams){
                player.add(playerName[i] + " " + playerSurname[i] + " " + playerLastname[i])
                playerid[i] = playerID[i]
            }
            i += 1
        }


        val plAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, player)
        binding.sPlayer.setAdapter(plAdapter)
    }

    fun assemblyPosition(){

        var i = 0
        var per: Int = 0
        var buf = binding.sPlayer.text.toString()
        playerName.forEach{
            if (buf == player[i]){
                per = playerid[i]
            }
            i += 1
        }

        var name = binding.etName.text.toString()
        var surname = binding.etSurname.text.toString()
        var lastname = binding.etLastname.text.toString()

        var disch = binding.sDisch.text.toString()
        var counter: Int = 0
        i = 0
        buf = binding.sDisch.text.toString()
        dischsList.forEach {
            if(buf == ServiceDischs.disch[i])
                counter = ServiceDischs.iddisch[i]
            else i += 1
        }


        var team = teamNumb.idTeams


        var kindofsport = binding.sSport.text.toString()
        var num = 0
        i = 0
        ServiceKindOfSports.kindofsportsList.forEach {
            if (buf == ServiceKindOfSports.processingSports[i]){
                num = ServiceKindOfSports.idSport[i]
            }else i += 1
        }


        var roll = binding.sRoll.text.toString()
        var value: Int = 0
        i = 0
        buf = binding.sRoll.text.toString()
        ServiceRolls.rollsList.forEach {
            if(buf == ServiceRolls.roll[i])
                value = ServiceRolls.idroll[i]
            else i += 1
        }


//        val position = Position(counter, name)
        PutPlayer(per, name, surname, lastname, counter, team, num, value).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}