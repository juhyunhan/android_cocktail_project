package com.example.cocktail_project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.cocktail_project.databinding.FragmentFailBinding

class FailFragment : Fragment() {
    var binding : FragmentFailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root_view = inflater.inflate(R.layout.fragment_fail, container, false)
        var return_btn = root_view.findViewById<Button>(R.id.btn_pickcocktail)

        return_btn.setOnClickListener {
            findNavController().navigate(R.id.action_failFragment_to_selectFragment)
        }

        return root_view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnPickcocktail?.setOnClickListener {
            findNavController().navigate(R.id.action_failFragment_to_selectFragment)
        }

        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_failFragment_to_startFragment)
        }




    }

}