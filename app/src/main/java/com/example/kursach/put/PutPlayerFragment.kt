package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.addfragments.AddPlayersFragment
import com.example.kursach.databinding.FragmentAddplayersBinding
import com.example.kursach.delete.DeletePlayer
import com.example.kursach.delete.DeleteRoll
import com.example.kursach.putservice.PutPlayer
import com.example.kursach.services.*
import com.example.kursach.services.ServiceDischs.dischsList
import com.example.kursach.services.ServiceKindOfSports.idSport
import com.example.kursach.services.ServiceKindOfSports.kindofsportsList
import com.example.kursach.services.ServiceKindOfSports.processingSports
import com.example.kursach.services.ServicePlayers.numberTeam
import com.example.kursach.services.ServicePlayers.playerID
import com.example.kursach.services.ServicePlayers.playerLastname
import com.example.kursach.services.ServicePlayers.playerName
import com.example.kursach.services.ServicePlayers.playerSurname
import com.example.kursach.teams.Team
import com.example.kursach.teams.TeamFragment

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
            assemblyPosition()
//            ServicePositions.positionsList.clear()
//            ServicePositions.positionsNameList.clear()
//            ServicePositions.start()
            (activity as? MainActivity)?.openFragment(AddPlayersFragment(teamNumb))
        }

        binding.btnDelete.setOnClickListener {
            delete()
            (activity as? MainActivity)?.openFragment(TeamFragment())
        }


        setTextInputLayout()

    }

    var player: MutableList<String> = emptyList<String>().toMutableList()
    var playerid: MutableList<Int> = emptyList<Int>().toMutableList()

    fun setTextInputLayout() {

        ServicePositions.positionsNameList.clear()
        ServiceDischs.disch.clear()
        ServiceRolls.roll.clear()
        ServicePositions.start()
        ServiceDischs.start()
        ServiceRolls.start()

//        var player: MutableList<PlayerForAdapter> = emptyList<PlayerForAdapter>().toMutableList()
//        player.add(PlayerForAdapter(playerName, playerSurname, playerLastname))
        var i = 0

        playerName.forEach{
            if (numberTeam[i] == teamNumb.idTeams){
                player.add(playerName[i] + " " + playerSurname[i] + " " + playerLastname[i])
                playerid.add(playerID[i])
            }
            i += 1
        }

        val firstAdapter = ArrayAdapter(requireContext(),R.layout.item_spinner, processingSports)
        binding.sSport.setAdapter(firstAdapter)

        val dischAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner,ServiceDischs.disch)
        binding.sDisch.setAdapter(dischAdapter)

        val rollAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceRolls.roll)
        binding.sRoll.setAdapter(rollAdapter)

        val plAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, player)
        binding.sPlayer.setAdapter(plAdapter)
    }

    fun assemblyPosition(){

        var i = 0
        var per: Int = 0
        var buf = binding.sPlayer.text.toString()
        player.forEach{
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


        buf = binding.sSport.text.toString()
        var num = 0
        i = 0
        kindofsportsList.forEach {
            if (buf == processingSports[i]){
                num = idSport[i]
            }
            i += 1
        }


//        var roll = binding.sRoll.text.toString()
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

    fun delete(){
        var i = 0
        var per: Int = 0
        var buf = binding.sPlayer.text.toString()
        player.forEach{
            if (buf == player[i]){
                per = playerid[i]
            }
            i += 1
        }
        DeletePlayer(per).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}