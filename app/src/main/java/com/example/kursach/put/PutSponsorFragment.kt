package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddsponsorBinding
import com.example.kursach.delete.DeleteRoll
import com.example.kursach.delete.DeleteSponsor
import com.example.kursach.putservice.PutSponsor
import com.example.kursach.services.*
import com.example.kursach.services.ServiceSponsors.nameSponsors
import com.example.kursach.services.ServiceSponsors.sponsorID
import com.example.kursach.services.ServiceSponsors.sponsorsList
import com.example.kursach.services.ServiceSportClubs.clubsList
import com.example.kursach.services.ServiceSportClubs.idClubs
import com.example.kursach.services.ServiceSportClubs.processingAddress
import com.example.kursach.sponsors.SponsorFragment
import com.example.kursach.teams.TeamFragment

class PutSponsorFragment: Fragment() {

    lateinit var binding: FragmentAddsponsorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddsponsorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {
            assemblySponsor()
            (activity as? MainActivity)?.openFragment(SponsorFragment())
        }

        binding.btnDelete.setOnClickListener {
            delete()
            (activity as? MainActivity)?.openFragment(SponsorFragment())
        }

        setTextInputLayout()

    }

    fun setTextInputLayout() {

        sponsorsList.clear()
        nameSponsors.clear()
        sponsorID.clear()
        ServiceSponsors.start()
        clubsList.clear()
        processingAddress.clear()
        idClubs.clear()
        ServiceSportClubs.start()

        val firstAdapter = ArrayAdapter(requireContext(),R.layout.item_spinner, nameSponsors)
        binding.sSponsor.setAdapter(firstAdapter)

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, processingAddress)
        binding.sAddress.setAdapter(arrayAdapter)

    }

    fun assemblySponsor(){


        var i = 0
        var per: Int = 0
        var buf = binding.sSponsor.text.toString()
        sponsorsList.forEach{
            if (buf == nameSponsors[i]){
                per = sponsorID[i]
            }
            i += 1
        }

        var name = binding.etName.text.toString()
        var number = binding.etNumber.text.toString()
        var mail = binding.etMail.text.toString()
        buf = binding.sAddress.text.toString()
        var num = 0
        i = 0
        processingAddress.forEach {
            if (buf == processingAddress[i]){
                num = idClubs[i]
            }else i += 1
        }

        PutSponsor(per, name, number, mail, num).start()
    }

    fun delete(){
        var i = 0
        var per: Int = 0
        var buf = binding.sSponsor.text.toString()
        sponsorsList.forEach{
            if (buf == nameSponsors[i]){
                per = sponsorID[i]
            }
            i += 1
        }
        DeleteSponsor(per).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}