package com.example.kursach.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddTeamFragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.addfragments.AddEventFragment
import com.example.kursach.addfragments.AddPlayersFragment
import com.example.kursach.addfragments.AddRollFragment
import com.example.kursach.databinding.FragmentPlayersBinding
import com.example.kursach.services.ServicePlayers.playersList

class PlayerFragment: Fragment() {

    lateinit var binding: FragmentPlayersBinding

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
            (activity as? MainActivity)?.openFragment(AddPlayersFragment())
        }
        binding.btnRoll.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddRollFragment())
        }



        val playerAdapter = PlayerAdapter(playersList)
        binding.rvPlayer.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvPlayer.adapter = playerAdapter


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}