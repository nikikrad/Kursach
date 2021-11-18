package com.example.kursach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kursach.databinding.FragmentAdddischBinding

class AddDischFragment: Fragment() {

    lateinit var binding: FragmentAdddischBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdddischBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (activity as? MainActivity)?.openFragment(EventFragment())

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}