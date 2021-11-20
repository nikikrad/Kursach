package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursach.databinding.FragmentEmployeeBinding

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
        binding.btnAddEmployee.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddEmployeeFragment())
        }
        binding.btnAddPosition.setOnClickListener {
            (activity as? MainActivity)?.openFragment(AddPositionFragment())
        }

        var employeeList = listOf(
            Employee("Алёша","Алексеев","Хуесос", "Директор"),
            Employee("Никитос","Шуриков","Александрович", "Хуесос"),
            Employee("Ден","Скурик","Хуесос", "Норм"),
            Employee("Синяга","Максимов","Писосов", "Орун"),
            Employee("Андрей","Алексеев","Маруевич", "Бомж"),
            Employee("Маруев","Синягов","Синягов", "Менеджер"),
            Employee("Алёша","Что","Хуесос", "Стажер"),
            )

        val EmployeeAdapter = EmployeeAdapter(employeeList)
        binding.rvEmployee.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvEmployee.adapter = EmployeeAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}