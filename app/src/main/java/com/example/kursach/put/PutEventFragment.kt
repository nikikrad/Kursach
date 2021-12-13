package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddeventBinding
import com.example.kursach.delete.DeleteEvent
import com.example.kursach.delete.DeleteRoll
import com.example.kursach.events.EventBody
import com.example.kursach.events.EventFragment
import com.example.kursach.postservice.PostEvent
import com.example.kursach.putservice.PutEvent
import com.example.kursach.services.*
import com.example.kursach.services.ServiceEvents.eventID
import com.example.kursach.services.ServiceEvents.eventdate
import com.example.kursach.services.ServiceEvents.eventsList
import com.example.kursach.services.ServiceEvents.eventsport
import com.example.kursach.services.ServiceEvents.eventtime
import com.example.kursach.services.ServiceSportClubs.processingAddress
import com.example.kursach.teams.TeamFragment

class PutEventFragment: Fragment() {

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

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {
            assemblyEvent()
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

        binding.btnDelete.setOnClickListener {
            delete()
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

        setTextInputLayout()

    }

    var event: MutableList<String> = emptyList<String>().toMutableList()


    fun setTextInputLayout() {

//        ServiceKindOfSports.processingSports.clear()
//        ServiceSportClubs.processingAddress.clear()
//        ServiceSportClubs.start()
//        ServiceKindOfSports.start()

        var list: MutableList<String> = emptyList<String>().toMutableList()

        eventsList.forEach {
            list.add(it.address)
        }


        var i = 0
        eventsList.forEach {
            event.add(eventsport[i] + " " + eventdate[i] + " " + eventtime[i] + " " + list[i])
            i+=1
        }


        val firstAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceKindOfSports.processingSports)
        binding.sSport.setAdapter(firstAdapter)

        val secondAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, processingAddress)
        binding.sAddress.setAdapter(secondAdapter)

        val thirdAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, event)
        binding.sEvent.setAdapter(thirdAdapter)

    }


    fun assemblyEvent(){

        var i = 0
        var per: Int = 0
        var buf = binding.sEvent.text.toString()
        event.forEach{
            if (buf == event[i]){
                per = eventID[i]
            }
            i += 1
        }

        var name = binding.sSport.text.toString()
        var date = binding.etDate.text.toString()
        var time = binding.etTime.text.toString()
        buf = binding.sAddress.text.toString()
        var num = 0
        i = 0

        processingAddress.forEach {
            if (buf == processingAddress[i]){
                num = ServiceSportClubs.idClubs[i]
            }else i += 1
        }


        PutEvent(per,  name, date, time, num).start()
    }

    fun delete(){
        var i = 0
        var per: Int = 0
        var buf = binding.sEvent.text.toString()
        event.forEach{
            if (buf == event[i]){
                per = eventID[i]
            }
            i += 1
        }
        DeleteEvent(per).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}