package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddsponsorBinding
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.put.PutSponsorFragment
import com.example.kursach.services.PostEmployee
import com.example.kursach.services.PostSponsor
import com.example.kursach.services.ServicePositions
import com.example.kursach.services.ServiceSportClubs
import com.example.kursach.sponsors.SponsorBody
import com.example.kursach.sponsors.SponsorFragment

class AddSponsorFragment: Fragment() {

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

        binding.btnAdd.setOnClickListener {
            assemblySponsor()
            (activity as? MainActivity)?.openFragment(SponsorFragment())
        }

        binding.btnEdit.setOnClickListener {
            (activity as? MainActivity)?.openFragment(PutSponsorFragment())
        }

        setTextInputLayout()

    }

    fun setTextInputLayout() {
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceSportClubs.processingAddress)
        binding.sAddress.setAdapter(arrayAdapter)

    }

    fun assemblySponsor(){
        var name = binding.etName.text.toString()
        var number = binding.etNumber.text.toString()
        var mail = binding.etMail.text.toString()
        var buf = binding.sAddress.text.toString()
        var num = 0
        var i = 0
        ServiceSportClubs.processingAddress.forEach {
            if (buf == ServiceSportClubs.processingAddress[i]){
                num = ServiceSportClubs.idClubs[i]
            }else i += 1
        }

        val sponsor = SponsorBody(0,  name, number, mail, num)
        PostSponsor(sponsor).start()
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}