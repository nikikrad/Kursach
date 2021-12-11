package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddteamBinding
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.services.PostEmployee
import com.example.kursach.services.PostTeam
import com.example.kursach.services.ServicePositions
import com.example.kursach.services.ServicePositions.positionsNameList
import com.example.kursach.services.ServiceSportClubs
import com.example.kursach.services.ServiceSportClubs.processingAddress
import com.example.kursach.teams.TeamBody
import com.example.kursach.teams.TeamFragment

class AddTeamFragment: Fragment() {

    lateinit var binding: FragmentAddteamBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddteamBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAdd.setOnClickListener {
            assemblyTeam()
            (activity as MainActivity).openFragment(TeamFragment())
        }
        setTextInputLayout()
    }

    fun setTextInputLayout() {

        processingAddress.clear()
        ServiceSportClubs.start()

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, processingAddress)
        binding.sAddress.setAdapter(arrayAdapter)
    }


    fun assemblyTeam(){
        var name = binding.etTeam.text.toString()
        var buf = binding.sAddress.text.toString()
        var num = 0
        var i = 0
        processingAddress.forEach {
            if (buf == processingAddress[i]){
                num = ServiceSportClubs.idClubs[i]
            }else i += 1
        }

        val team = TeamBody(0,  name, num)
        PostTeam(team).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}