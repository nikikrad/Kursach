package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddeventBinding
import com.example.kursach.events.EventBody
import com.example.kursach.events.EventFragment
import com.example.kursach.kindofsports.KindOfSport
import com.example.kursach.services.*
import com.example.kursach.services.ServiceKindOfSports.idSport
import com.example.kursach.services.ServiceKindOfSports.processingSports
import com.example.kursach.services.ServiceSportClubs.idClubs
import com.example.kursach.services.ServiceSportClubs.processingAddress
import com.example.kursach.sponsors.SponsorBody

class AddEventFragment: Fragment() {

    lateinit var binding: FragmentAddeventBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddeventBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAdd.setOnClickListener {
            assemblyEvent()
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

        setTextInputLayout()

    }

    fun setTextInputLayout() {

        processingSports.clear()
        processingAddress.clear()
        ServiceSportClubs.start()
        ServiceKindOfSports.start()

        val firstAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, processingSports)
        binding.sSport.setAdapter(firstAdapter)

        val secondAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, processingAddress)
        binding.sAddress.setAdapter(secondAdapter)

    }


    fun assemblyEvent(){
        var name = binding.sSport.text.toString()
        var date = binding.etDate.text.toString()
        var time = binding.etTime.text.toString()
        var buf = binding.sAddress.text.toString()
        var num = 0
        var i = 0

        processingAddress.forEach {
            if (buf == processingAddress[i]){
                num = idClubs[i]
            }else i += 1
        }


        val event = EventBody(0,  name, date, time, num)
        PostEvent(event).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
