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
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.events.EventFragment
import com.example.kursach.players.Player
import com.example.kursach.players.PlayerBody
import com.example.kursach.players.PlayerFragment
import com.example.kursach.services.*

class AddPlayersFragment: Fragment() {

    lateinit var binding: FragmentAddplayersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddplayersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAdd.setOnClickListener{
            (activity as? MainActivity)?.openFragment(PlayerFragment())
        }

        val firstAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceKindOfSports.processingSports)
        binding.sDisch.setAdapter(firstAdapter)

        val dischAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceDischs.disch)
        binding.sDisch.setAdapter(dischAdapter)

        val rollAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceRolls.roll)
        binding.sDisch.setAdapter(rollAdapter)
    }

    fun assemblyEmployee(){
        var name = binding.etName.text.toString()
        var surname = binding.etSurname.text.toString()
        var lastname = binding.etLastname.text.toString()
        var buf = binding.sSport.text.toString()
        var num = 0
        var i = 0
        ServiceKindOfSports.kindofsportsList.forEach {
            if (buf == ServiceKindOfSports.processingSports[i]){
                num = ServiceKindOfSports.idSport[i]
            }else i += 1
        }

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


        val player = PlayerBody(0,  name, surname, lastname, num, counter, value)
        PostPlayer(player).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}