package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddplayersBinding
import com.example.kursach.players.PlayerBody
import com.example.kursach.players.PlayerFragment
import com.example.kursach.postservice.PostPlayer
import com.example.kursach.put.PutPlayerFragment
import com.example.kursach.services.*
import com.example.kursach.services.ServiceDischs.disch
import com.example.kursach.services.ServiceKindOfSports.kindofsportsList
import com.example.kursach.services.ServiceKindOfSports.processingSports
import com.example.kursach.services.ServiceRolls.roll
import com.example.kursach.teams.Team

class AddPlayersFragment(var team: Team): Fragment() {

    lateinit var binding: FragmentAddplayersBinding
    var teamNaming = team

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddplayersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setTextInputLayout()

        binding.btnAdd.setOnClickListener {
            assemblyPlayer()
            (activity as? MainActivity)?.openFragment(PlayerFragment(teamNaming))
        }

        binding.btnEdit.setOnClickListener {
            (activity as? MainActivity)?.openFragment(PutPlayerFragment(teamNaming))
        }
    }
    fun setTextInputLayout() {

        processingSports.clear()
        disch.clear()
        roll.clear()
        kindofsportsList.clear()
        ServiceKindOfSports.start()
        ServiceDischs.start()
        ServiceRolls.start()

        val firstAdapter = ArrayAdapter(requireContext(),R.layout.item_spinner,processingSports)
        binding.sSport.setAdapter(firstAdapter)

        val dischAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, disch)
        binding.sDisch.setAdapter(dischAdapter)

        val rollAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, roll)
        binding.sRoll.setAdapter(rollAdapter)
    }

    fun assemblyPlayer(){
        var name = binding.etName.text.toString()
        var surname = binding.etSurname.text.toString()
        var lastname = binding.etLastname.text.toString()
        var buf = binding.sSport.text.toString()
        var num = 0
        var i = 0
        kindofsportsList.forEach {
            if (buf == ServiceKindOfSports.processingSports[i]){
                num = ServiceKindOfSports.idSport[i]
            }else i += 1
        }

        var teamname = teamNaming.idTeams

        var counter: Int = 0
        i = 0
        buf = binding.sDisch.text.toString()
        ServiceDischs.dischsList.forEach {
            if(buf == ServiceDischs.disch[i])
                counter = ServiceDischs.iddisch[i]
            else i += 1
        }



        var value: Int = 0
        i = 0
        buf = binding.sRoll.text.toString()
        ServiceRolls.rollsList.forEach {
            if(buf == ServiceRolls.roll[i])
                value = ServiceRolls.idroll[i]
            else i += 1
        }


        val player = PlayerBody(0,  name, surname, lastname, counter, teamname, num , value)
        PostPlayer(player).start()
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}