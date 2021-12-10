package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentAddemployeeBinding
import com.example.kursach.employees.EmployeeFragment
import android.widget.ArrayAdapter
import com.example.kursach.R
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.services.ServiceEmployees
import com.example.kursach.services.ServicePositions.idPositionsList
import com.example.kursach.services.ServicePositions.positionsNameList
import com.example.kursach.services.ServiceSportClubs
import com.example.kursach.services.ServiceSportClubs.clubsList
import com.example.kursach.services.ServiceSportClubs.idClubs
import com.example.kursach.services.ServiceSportClubs.processingAddress
import com.example.kursach.services.TestPostRequest


class AddEmployeeFragment: Fragment(){

    lateinit var binding: FragmentAddemployeeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddemployeeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAdd.setOnClickListener {
            (activity as? MainActivity)?.openFragment(EmployeeFragment())
        }

        binding.btnAdd.setOnClickListener {
            assemblyEmployee()
        }

        setTextInputLayout()

    }

    fun setTextInputLayout() {
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, processingAddress)
        binding.sAddress.setAdapter(arrayAdapter)

        val posAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, positionsNameList)
        binding.sPositions.setAdapter(posAdapter)
    }

    fun assemblyEmployee(){
        var name = binding.etName.text.toString()
        var surname = binding.etSurname.text.toString()
        var lastname = binding.etLastname.text.toString()
        var buf = binding.sAddress.text.toString()

        var num = 0
        var i = 0
        processingAddress.forEach {
            if (buf == processingAddress[i]){
                num = idClubs[i]
            }else i += 1
        }

        var counter: Int = 0
        i = 0
        buf = binding.sPositions.text.toString()
        positionsNameList.forEach {
            if(buf == positionsNameList[i])
                counter = idPositionsList[i]
            else i += 1
        }


        val employee = EmployeeBody(0,  name, surname, lastname, counter, num)
        TestPostRequest(employee).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}