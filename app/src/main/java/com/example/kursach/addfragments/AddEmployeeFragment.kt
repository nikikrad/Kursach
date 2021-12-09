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
import com.example.kursach.services.ServiceSportClubs.processingAddress


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


        setTextInputLayout()

    }

    fun setTextInputLayout() {
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, processingAddress)
        binding.autoCompleteTV.setAdapter(arrayAdapter)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}