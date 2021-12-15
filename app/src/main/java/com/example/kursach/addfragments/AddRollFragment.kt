package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentAddrollBinding
import com.example.kursach.events.EventFragment
import com.example.kursach.players.PlayerFragment
import com.example.kursach.rolls.Roll
import com.example.kursach.postservice.PostRoll
import com.example.kursach.put.PutRollFragment
import com.example.kursach.services.ServiceRolls
import com.example.kursach.teams.Team


class AddRollFragment (var team: Team): Fragment() {

    var bufTeam = team
    lateinit var binding: FragmentAddrollBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddrollBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAdd.setOnClickListener {
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

        binding.btnAdd.setOnClickListener {
            assemblyRoll()
            ServiceRolls.rollsList.clear()
            ServiceRolls.roll.clear()
            ServiceRolls.idroll.clear()
            ServiceRolls.start()
            (activity as? MainActivity)?.openFragment(PlayerFragment(bufTeam))
        }

        binding.btnEdit.setOnClickListener {
            (activity as? MainActivity)?.openFragment(PutRollFragment())
        }

    }

    fun assemblyRoll(){
        var name = binding.etRoll.text.toString()
        val roll = Roll(0, name)
        PostRoll(roll).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}