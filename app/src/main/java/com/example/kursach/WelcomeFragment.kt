package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.databinding.FragmentWelcomeBinding
import com.example.kursach.events.EventFragment
import com.example.kursach.put.PutPlayerFragment

class WelcomeFragment: Fragment() {

    lateinit var binding: FragmentWelcomeBinding

    companion object{
        var LOGGIN: String = "0"
        var PASSWORD: String = "0"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.btnEnter.setOnClickListener {
            LOGGIN = binding.etLogin.text.toString()
            PASSWORD = binding.etPassword.text.toString()
            (activity as? MainActivity)?.openFragment(EventFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}