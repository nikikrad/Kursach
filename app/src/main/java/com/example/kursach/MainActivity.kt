package com.example.kursach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import com.example.kursach.databinding.ActivityMainBinding
import android.widget.Toast
import com.example.kursach.clubs.ClubFragment
import com.example.kursach.employees.EmployeeFragment
import com.example.kursach.events.EventFragment
import com.example.kursach.sponsors.SponsorFragment
import com.example.kursach.teams.TeamFragment
import com.example.kursach.test.Service


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(WelcomeFragment())

        Service.start()

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
            openFragment(ClubFragment())
        }
        binding.btnWelcome.setOnClickListener {
            openFragment(WelcomeFragment())
        }


    }

    private var exit = false
    override fun onBackPressed() {
        if (exit) {
            finish() // finish activity
        } else {
            Toast.makeText(
                this, "Повторите действие для выхода из программы",
                Toast.LENGTH_SHORT
            ).show()
            exit = true
            Handler().postDelayed(Runnable { exit = false }, 3 * 1000)
        }
    }



    fun openFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, fragment)
//            .addToBackStack(null)
            .commit()
    }
}