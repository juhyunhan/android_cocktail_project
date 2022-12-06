package com.example.cocktail_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cocktail_project.databinding.FragmentSelectBinding
import com.example.cocktail_project.databinding.FragmentStartBinding


/**
 * A simple [Fragment] subclass.
 * Use the [startFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class startFragment : Fragment() {

    var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)


        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding?.btnMainstart?.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_selectFragment)

       }

    }
}
