package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddteamBinding
import com.example.kursach.services.PostTeam
import com.example.kursach.services.PutTeam
import com.example.kursach.services.ServiceSportClubs
import com.example.kursach.services.ServiceTeams
import com.example.kursach.services.ServiceTeams.teamID
import com.example.kursach.services.ServiceTeams.teamNaming
import com.example.kursach.services.ServiceTeams.teamsList
import com.example.kursach.teams.TeamBody
import com.example.kursach.teams.TeamFragment

class PutTeamFragment: Fragment() {

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

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {
            assemblyTeam()
            (activity as MainActivity).openFragment(TeamFragment())
        }
        setTextInputLayout()
    }

    fun setTextInputLayout() {

//        ServiceSportClubs.clubsList.clear()
//        ServiceSportClubs.processingAddress.clear()
//        ServiceSportClubs.idClubs.clear()
//        ServiceSportClubs.start()
//        teamsList.clear()
//        teamID.clear()
//        teamName.clear()
//        ServiceTeams.start()


        val firstAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, teamNaming)
        binding.sTeam.setAdapter(firstAdapter)

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceSportClubs.processingAddress)
        binding.sAddress.setAdapter(arrayAdapter)
    }


    fun assemblyTeam(){

        var i = 0
        var per: Int = 0
        var buf = binding.sTeam.text.toString()
        teamNaming.forEach{
            if (buf == teamNaming[i]){
                per = teamID[i]
            }
            i += 1
        }

        var name = binding.etTeam.text.toString()
        buf = binding.sAddress.text.toString()
        var num = 0
        i = 0
        ServiceSportClubs.processingAddress.forEach {
            if (buf == ServiceSportClubs.processingAddress[i]){
                num = ServiceSportClubs.idClubs[i]
            }else i += 1
        }

        PutTeam(per, name, num).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}