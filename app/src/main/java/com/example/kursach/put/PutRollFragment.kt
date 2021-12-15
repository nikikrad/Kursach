package com.example.kursach.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kursach.MainActivity
import com.example.kursach.R
import com.example.kursach.databinding.FragmentAddrollBinding
import com.example.kursach.delete.DeleteRoll
import com.example.kursach.events.EventFragment
import com.example.kursach.players.PlayerFragment
import com.example.kursach.postservice.PostRoll
import com.example.kursach.putservice.PutRoll
import com.example.kursach.rolls.Roll
import com.example.kursach.services.ServicePositions
import com.example.kursach.services.ServiceRolls
import com.example.kursach.services.ServiceRolls.idroll
import com.example.kursach.services.ServiceRolls.roll
import com.example.kursach.teams.TeamFragment

class PutRollFragment: Fragment() {

    lateinit var binding: FragmentAddrollBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddrollBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.spinner.visibility = View.VISIBLE
        binding.btnDelete.visibility = View.VISIBLE
        binding.btnEdit.visibility = View.INVISIBLE

        binding.btnAdd.setOnClickListener {
            assemblyRoll()
            ServiceRolls.rollsList.clear()
            ServiceRolls.roll.clear()
            ServiceRolls.rollsList.clear()
            ServiceRolls.start()
            (activity as? MainActivity)?.openFragment(TeamFragment())
        }
        binding.btnDelete.setOnClickListener {
            delete()
            (activity as? MainActivity)?.openFragment(TeamFragment())
        }

        setTextInputLayout()

    }

    fun setTextInputLayout() {

//        ServicePositions.positionsNameList.clear()
//        ServicePositions.start()

        val posAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, roll)
        binding.sRoll.setAdapter(posAdapter)
    }

    fun assemblyRoll(){

        var counter: Int = 0
        var i = 0
        var buf = binding.sRoll.text.toString()
        roll.forEach {
            if(buf == roll[i]){
                counter = idroll[i]
            }
            i += 1
        }

        var name = binding.etRoll.text.toString()

        PutRoll(counter, name).start()
    }

    fun delete(){
        var counter: Int = 0
        var i = 0
        var buf = binding.sRoll.text.toString()
        roll.forEach {
            if(buf == roll[i]){
                counter = idroll[i]
            }
            i += 1
        }
        DeleteRoll(counter).start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}