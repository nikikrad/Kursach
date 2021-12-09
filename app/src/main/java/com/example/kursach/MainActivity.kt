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
import com.example.kursach.services.*
import com.example.kursach.services.ServiceDischs.dischsList
import com.example.kursach.services.ServiceEmployees.employeesList
import com.example.kursach.services.ServiceEvents.eventsList
import com.example.kursach.services.ServiceKindOfSports.kindofsportsList
import com.example.kursach.services.ServicePlayers.playersList
import com.example.kursach.services.ServicePositions.positionsList
import com.example.kursach.services.ServiceRolls.rollsList
import com.example.kursach.services.ServiceSponsors.sponsorsList
import com.example.kursach.services.ServiceSportClubs.clubsList
import com.example.kursach.services.ServiceTeams.teamsList
import com.example.kursach.sponsors.SponsorFragment
import com.example.kursach.teams.TeamFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(WelcomeFragment())

        ServiceSportClubs.start()
        ServiceEvents.start()
        ServiceTeams.start()
        ServiceDischs.start()
        ServiceKindOfSports.start()
        ServicePositions.start()
        ServiceRolls.start()
        ServiceEmployees.start()
        ServicePlayers.start()
        ServiceSponsors.start()
//        TestPostRequest(hui).start()


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
            eventsList.clear()
            teamsList.clear()
            dischsList.clear()
            employeesList.clear()
            kindofsportsList.clear()
            playersList.clear()
            positionsList.clear()
            rollsList.clear()
            sponsorsList.clear()
            clubsList.clear()
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