package com.example.kursach.clubs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddClubFragment
import com.example.kursach.MainActivity
import com.example.kursach.WelcomeFragment
import com.example.kursach.WelcomeFragment.Companion.LOGGIN
import com.example.kursach.WelcomeFragment.Companion.PASSWORD
import com.example.kursach.databinding.FragmentClubBinding
import com.example.kursach.services.ServiceSportClubs
import com.example.kursach.services.ServiceSportClubs.clubsList

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

        if(LOGGIN == "admin" || PASSWORD == "admin"){
            binding.btnClubs.visibility = View.VISIBLE
        }else binding.btnClubs.visibility = View.GONE

        binding.btnClubs.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddClubFragment())
        }


        val clubAdapter = ClubAdapter(clubsList)
        binding.rvClub.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvClub.adapter = clubAdapter

        binding.btnUpdate.setOnClickListener {
            clubsList.clear()
            ServiceSportClubs.start()
            val clubAdapter = ClubAdapter(clubsList)
            binding.rvClub.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvClub.adapter = clubAdapter
            Thread.sleep(500)
            (activity as? MainActivity)?.openFragment(ClubFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}