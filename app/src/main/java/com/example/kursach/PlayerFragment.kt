package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.databinding.FragmentPlayersBinding
import com.example.kursach.databinding.FragmentTeamBinding

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

        binding.btnBack.setOnClickListener {
            (activity as MainActivity).openFragment(AddTeamFragment())
        }

        var playerList = listOf(
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой"),
                Player("Nikitpos", "Shurikov", "Olegovna", "1 Юношеский", "Гандонбол", "Угловой")
        )

        val teamAdapter = TeamsAdapter(playerList)
        binding.rvPlayer.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvPlayer.adapter = PlayerAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}