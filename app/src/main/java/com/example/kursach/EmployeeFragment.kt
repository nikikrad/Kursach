package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}