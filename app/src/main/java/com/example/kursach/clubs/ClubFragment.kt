package com.example.kursach.clubs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddClubFragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentClubBinding

class ClubFragment: Fragment() {

    lateinit var binding: FragmentClubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClubBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnClubs.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddClubFragment())
        }

        var clubList = listOf(
            Club("Liqued", "+37544553191", "HUI@bsuir.by" ),
            Club("Govnary", "+37544553191", "nikitos@bsuir.by" ),
            Club("Bazuki", "+37544555191", "artem@bsuir.by" ),
            Club("Kek", "+37544553132", "den@bsuir.by" ),
            Club("Shlep", "+37544753191", "shurikov.shura@bsuir.by" ),
            Club("Zhopa", "+37544533191", "shuriniv,nikita@bsuir.by" ),
            Club("Lolita", "+37529553391", "dsfhjd@bsuir.by" ),

            )

        val clubAdapter = ClubAdapter(clubList)
        binding.rvClub.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvClub.adapter = clubAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}