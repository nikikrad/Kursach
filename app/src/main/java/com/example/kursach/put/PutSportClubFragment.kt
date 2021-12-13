package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.clubs.Club
import com.example.kursach.clubs.ClubFragment
import com.example.kursach.databinding.FragmentAddclubBinding
import com.example.kursach.delete.DeleteClub
import com.example.kursach.delete.DeleteRoll
import com.example.kursach.postservice.PostSportClub
import com.example.kursach.putservice.PutClub
import com.example.kursach.services.ServicePositions
import com.example.kursach.services.ServiceRolls
import com.example.kursach.services.ServiceSportClubs
import com.example.kursach.services.ServiceSportClubs.idClubs
import com.example.kursach.services.ServiceSportClubs.processingAddress
import com.example.kursach.teams.TeamFragment

class PutSportClubFragment: Fragment() {

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

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {
            assemblyClub()
            (activity as? MainActivity)?.openFragment(ClubFragment())
        }

        binding.btnDelete.setOnClickListener {
            delete()
            (activity as? MainActivity)?.openFragment(ClubFragment())
        }

        setTextInputLayout()

    }

    fun setTextInputLayout() {

//        ServicePositions.positionsNameList.clear()
//        ServicePositions.start()

        val posAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner,processingAddress)
        binding.sClub.setAdapter(posAdapter)
    }



    fun assemblyClub(){

        var counter: Int = 0
        var i = 0
        var buf = binding.sClub.text.toString()
        processingAddress.forEach {
            if(buf == processingAddress[i]){
                counter = idClubs[i]
            }else i += 1
        }

        var address = binding.etName.text.toString()
        var number = binding.etNumber.text.toString()
        var mail = binding.etMail.text.toString()

        PutClub(counter,  address, number, mail).start()
    }

    fun delete(){
        var counter: Int = 0
        var i = 0
        var buf = binding.sClub.text.toString()
        processingAddress.forEach {
            if(buf == processingAddress[i]){
                counter = idClubs[i]
            }else i += 1
        }
        DeleteClub(counter).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}