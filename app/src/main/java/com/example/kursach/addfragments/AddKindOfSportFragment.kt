package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentAddkindofsportBinding
import com.example.kursach.events.EventFragment

class AddKindOfSportFragment: Fragment() {

    lateinit var binding: FragmentAddkindofsportBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddkindofsportBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (activity as? MainActivity)?.openFragment(EventFragment())

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}