package com.example.kursach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kursach.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(EventFragment())

        binding.btnEvents.setOnClickListener {
            openFragment(EventFragment())
        }
        binding.btnTeams.setOnClickListener {
            openFragment(TeamFragment())
        }
        binding.btnEmployers.setOnClickListener {
            openFragment(EmployeeFragment())
        }
        binding.btnSponsor.setOnClickListener {
            openFragment(SponsorFragment())
        }
        binding.btnClubs.setOnClickListener {
            openFragment(SponsorFragment())
        }
    }



    fun openFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}