package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}