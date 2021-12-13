package com.example.kursach.addfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.databinding.FragmentAddpositionBinding
import com.example.kursach.employees.EmployeeFragment
import com.example.kursach.positions.Position
import com.example.kursach.put.PutPositionsFragment
import com.example.kursach.postservice.PostPosition
import com.example.kursach.services.ServicePositions
import com.example.kursach.services.ServicePositions.positionsList
import com.example.kursach.services.ServicePositions.positionsNameList

class AddPositionFragment: Fragment() {

    lateinit var binding: FragmentAddpositionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddpositionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnAdd.setOnClickListener {
            assemblyPosition()
            positionsList.clear()
            positionsNameList.clear()
            ServicePositions.start()
            (activity as? MainActivity)?.openFragment(EmployeeFragment())
        }

        binding.btnEdit.setOnClickListener {
            (activity as? MainActivity)?.openFragment(PutPositionsFragment())
        }



    }

    fun assemblyPosition(){
        var name = binding.etPosition.text.toString()
        val position = Position(0, name)
        PostPosition(position).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}