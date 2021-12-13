package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.clubs.Club
import com.example.kursach.clubs.ClubFragment
import com.example.kursach.databinding.FragmentAddclubBinding
import com.example.kursach.postservice.PostSportClub
import com.example.kursach.put.PutSportClubFragment

class AddClubFragment: Fragment() {

    lateinit var binding: FragmentAddclubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddclubBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAdd.setOnClickListener {
            assemblyClub()
            (activity as? MainActivity)?.openFragment(ClubFragment())
        }

        binding.btnEdit.setOnClickListener {
            (activity as? MainActivity)?.openFragment(PutSportClubFragment())
        }
    }

    fun assemblyClub(){
        var address = binding.etName.text.toString()
        var number = binding.etNumber.text.toString()
        var mail = binding.etMail.text.toString()

        val club = Club(0,  address, number, mail)
        PostSportClub(club).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}