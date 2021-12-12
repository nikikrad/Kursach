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
import com.example.kursach.services.PutPosition
import com.example.kursach.services.ServicePlayers.numberTeam
import com.example.kursach.services.ServicePlayers.playerLastname
import com.example.kursach.services.ServicePlayers.playerName
import com.example.kursach.services.ServicePlayers.playerSurname
import com.example.kursach.services.ServicePlayers.playersList
import com.example.kursach.services.ServicePositions
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

    fun setTextInputLayout() {

        ServicePositions.positionsNameList.clear()
        ServicePositions.start()

//        var player: MutableList<PlayerForAdapter> = emptyList<PlayerForAdapter>().toMutableList()
//        player.add(PlayerForAdapter(playerName, playerSurname, playerLastname))
        var i = 0
        var player: MutableList<String> = emptyList<String>().toMutableList()
        playerName.forEach{
            if (numberTeam[i] == teamNumb.idTeams){
                player.add(playerName[i] + " " + playerSurname[i] + " " + playerLastname[i])
            }
            i += 1
        }


        val plAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, player)
        binding.sPlayer.setAdapter(plAdapter)
    }

    fun assemblyPosition(){
        var name = binding.etName.text.toString()
        var surname = binding.etSurname.text.toString()
        var lastname = binding.etLastname.text.toString()
        var disch = binding.sDisch.text.toString()
        var team = teamNumb
        var kindofsport = binding.sSport.text.toString()
        var roll = binding.sRoll.text.toString()

        var counter: Int = 0
        var i = 0
        var buf = binding.sPositions.text.toString()
        ServicePositions.positionsNameList.forEach {
            if(buf == ServicePositions.positionsNameList[i]){
                counter = ServicePositions.idPositionsList[i]
            }else i += 1
        }

//        val position = Position(counter, name)
        PutPosition(counter, name).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}