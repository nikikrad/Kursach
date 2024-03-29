package com.example.kursach.sponsors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.MainActivity
import com.example.kursach.WelcomeFragment
import com.example.kursach.WelcomeFragment.Companion.LOGGIN
import com.example.kursach.WelcomeFragment.Companion.PASSWORD
import com.example.kursach.addfragments.AddSponsorFragment
import com.example.kursach.databinding.FragmentSponsorBinding
import com.example.kursach.services.ServiceSponsors
import com.example.kursach.services.ServiceSponsors.sponsorsList

class SponsorFragment: Fragment() {

    lateinit var binding: FragmentSponsorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSponsorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if(LOGGIN == "admin" || PASSWORD == "admin"){
            binding.btnAddSponsor.visibility = View.VISIBLE
        }else {
            binding.btnAddSponsor.visibility = View.GONE
        }

        binding.btnAddSponsor.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddSponsorFragment())
        }

        val sponsorAdapter = SponsorAdapter(sponsorsList)
        binding.rvSponsor.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvSponsor.adapter = sponsorAdapter

        binding.btnUpdate.setOnClickListener {
            sponsorsList.clear()
            ServiceSponsors.start()
            val sponsorAdapter = SponsorAdapter(sponsorsList)
            binding.rvSponsor.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvSponsor.adapter = sponsorAdapter
            Thread.sleep(500)
            (activity as? MainActivity)?.openFragment(SponsorFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}