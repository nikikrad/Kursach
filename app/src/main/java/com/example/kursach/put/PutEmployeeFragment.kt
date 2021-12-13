package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddemployeeBinding
import com.example.kursach.employees.EmployeeBody
import com.example.kursach.employees.EmployeeFragment
import com.example.kursach.services.*
import com.example.kursach.services.ServiceEmployees.employeeID
import com.example.kursach.services.ServiceEmployees.employeeLastname
import com.example.kursach.services.ServiceEmployees.employeeName
import com.example.kursach.services.ServiceEmployees.employeeSurname
import com.example.kursach.services.ServicePositions.idPositionsList
import com.example.kursach.services.ServicePositions.positionsList
import com.example.kursach.services.ServicePositions.positionsNameList
import com.example.kursach.services.ServiceSportClubs.clubsList
import com.example.kursach.services.ServiceSportClubs.idClubs
import com.example.kursach.services.ServiceSportClubs.processingAddress

class PutEmployeeFragment: Fragment() {

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

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {

            assemblyEmployee()

            (activity as? MainActivity)?.openFragment(EmployeeFragment())
        }



        setTextInputLayout()

    }

    var employee: MutableList<String> = emptyList<String>().toMutableList()

    fun setTextInputLayout() {

        idPositionsList.clear()
        positionsNameList.clear()
        positionsList.clear()
        idClubs.clear()
        processingAddress.clear()
        clubsList.clear()



        ServiceSportClubs.start()
        ServicePositions.start()


        var i = 0
        employeeName.forEach {
            employee.add(employeeName[i] + " " + employeeSurname[i] + " " + employeeLastname[i])
            i+=1
        }

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServiceSportClubs.processingAddress)
        binding.sAddress.setAdapter(arrayAdapter)

        val posAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, ServicePositions.positionsNameList)
        binding.sPositions.setAdapter(posAdapter)

        val empAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, employee)
        binding.sEmployee.setAdapter(empAdapter)
    }

    fun assemblyEmployee(){

        var i = 0
        var per: Int = 0
        var buf = binding.sEmployee.text.toString()
        employeeName.forEach{
            if (buf == employee[i]){
                per = employeeID[i]
            }
            i += 1
        }

        var name = binding.etName.text.toString()

        var surname = binding.etSurname.text.toString()

        var lastname = binding.etLastname.text.toString()

        buf = binding.sAddress.text.toString()



        var num = 0
        i = 0
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


        PutEmployee(per,  name, surname, lastname, counter, num).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}