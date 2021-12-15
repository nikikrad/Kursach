package com.example.kursach.employees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.addfragments.AddPositionFragment
import com.example.kursach.MainActivity
import com.example.kursach.WelcomeFragment
import com.example.kursach.WelcomeFragment.Companion.LOGGIN
import com.example.kursach.WelcomeFragment.Companion.PASSWORD
import com.example.kursach.addfragments.AddEmployeeFragment
import com.example.kursach.databinding.FragmentEmployeeBinding
import com.example.kursach.services.ServiceEmployees
import com.example.kursach.services.ServiceEmployees.employeeID
import com.example.kursach.services.ServiceEmployees.employeesList

class EmployeeFragment: Fragment() {
    lateinit var binding: FragmentEmployeeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if(LOGGIN == "admin" || PASSWORD == "admin"){
            binding.btnAddEmployee.visibility = View.VISIBLE
            binding.btnAddPosition.visibility = View.VISIBLE
        }else {
            binding.btnAddEmployee.visibility = View.GONE
            binding.btnAddPosition.visibility = View.GONE
        }

        binding.btnAddEmployee.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddEmployeeFragment())
        }
        binding.btnAddPosition.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddPositionFragment())
        }


        val EmployeeAdapter = EmployeeAdapter(employeesList)
        binding.rvEmployee.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvEmployee.adapter = EmployeeAdapter

        binding.btnUpdate.setOnClickListener {
            ServiceEmployees.employeeName.clear()
            ServiceEmployees.employeeSurname.clear()
            ServiceEmployees.employeeLastname.clear()
            employeesList.clear()
            employeeID.clear()
            ServiceEmployees.start()
            val EmployeeAdapter = EmployeeAdapter(employeesList)
            binding.rvEmployee.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvEmployee.adapter = EmployeeAdapter
            Thread.sleep(500)
            (activity as? MainActivity)?.openFragment(EmployeeFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}