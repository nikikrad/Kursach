package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentAddplayersBinding
import com.example.kursach.events.EventFragment
import com.example.kursach.players.PlayerFragment

class AddPlayersFragment: Fragment() {

    lateinit var binding: FragmentAddplayersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddplayersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnAdd.setOnClickListener{

            (activity as? MainActivity)?.openFragment(PlayerFragment())
        }


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}