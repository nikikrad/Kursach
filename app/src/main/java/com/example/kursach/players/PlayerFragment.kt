package com.example.kursach.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.addfragments.AddTeamFragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentPlayersBinding
import com.example.kursach.teams.ClickTeam
import com.example.kursach.teams.TeamFragment
import com.example.kursach.teams.Teams

class PlayerFragment: Fragment(), ClickTeam {

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

//        val playerAdapter = PlayerAdapter(playerList)
//        binding.rvPlayer.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
//        binding.rvPlayer.adapter = PlayerAdapter
    }

    override fun sendData(teamsList: List<Teams>) {
        val teamFragment= TeamFragment()
        val bundle = Bundle()
        bundle.putInt("данные", teamsList: List<Teams>)
        childFragmentManager.beginTransaction().replace(R.id.contentContainerT, teamFragment).addToBackStack(null).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}