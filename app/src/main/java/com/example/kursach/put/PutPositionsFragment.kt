package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddpositionBinding
import com.example.kursach.delete.DeletePosition
import com.example.kursach.delete.DeleteRoll
import com.example.kursach.employees.EmployeeFragment
import com.example.kursach.putservice.PutPosition
import com.example.kursach.services.ServicePositions
import com.example.kursach.services.ServicePositions.idPositionsList
import com.example.kursach.services.ServicePositions.positionsNameList
import com.example.kursach.services.ServiceRolls
import com.example.kursach.teams.TeamFragment

class PutPositionsFragment:  Fragment(){
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

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {
            assemblyPosition()
            ServicePositions.positionsList.clear()
            ServicePositions.positionsNameList.clear()
            ServicePositions.start()
            (activity as? MainActivity)?.openFragment(EmployeeFragment())
        }

        binding.btnDelete.setOnClickListener {
            delete()
            (activity as? MainActivity)?.openFragment(EmployeeFragment())
        }


        setTextInputLayout()

    }

    fun setTextInputLayout() {

        positionsNameList.clear()
        ServicePositions.start()

        val posAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, positionsNameList)
        binding.sPositions.setAdapter(posAdapter)
    }

    fun assemblyPosition(){
        var name = binding.etPosition.text.toString()

        var counter: Int = 0
        var i = 0
        var buf = binding.sPositions.text.toString()
        positionsNameList.forEach {
            if(buf == positionsNameList[i]){
                counter = idPositionsList[i]
            }else i += 1
        }

//        val position = Position(counter, name)
        PutPosition(counter, name).start()
    }

    fun delete(){
        var counter: Int = 0
        var i = 0
        var buf = binding.sPositions.text.toString()
        positionsNameList.forEach {
            if(buf == positionsNameList[i]){
                counter = idPositionsList[i]
            }else i += 1
        }
        DeletePosition(counter).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}