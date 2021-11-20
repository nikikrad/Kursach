package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.databinding.FragmentSponsorBinding

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
        binding.btnAddSponsor.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddSponsorFragment())
        }

        var sponsorList = listOf(
            Sponsor("Liqued", "+37544553191", "HUI@bsuir.by" ),
            Sponsor("Govnary", "+37544553191", "nikitos@bsuir.by" ),
            Sponsor("Bazuki", "+37544555191", "artem@bsuir.by" ),
            Sponsor("Kek", "+37544553132", "den@bsuir.by" ),
            Sponsor("Shlep", "+37544753191", "shurikov.shura@bsuir.by" ),
            Sponsor("Zhopa", "+37544533191", "shuriniv,nikita@bsuir.by" ),
            Sponsor("Lolita", "+37529553391", "dsfhjd@bsuir.by" ),

        )

        val sponsorAdapter = SponsorAdapter(sponsorList)
        binding.rvSponsor.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvSponsor.adapter = sponsorAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}