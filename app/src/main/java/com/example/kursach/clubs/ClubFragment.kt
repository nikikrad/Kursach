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
import com.example.kursach.test.ServiceSportClubs.clubsList

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


        val clubAdapter = ClubAdapter(clubsList)
        binding.rvClub.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvClub.adapter = clubAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}