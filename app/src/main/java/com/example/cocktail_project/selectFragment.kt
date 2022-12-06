package com.example.cocktail_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cocktail_project.databinding.FragmentSelectBinding

class SelectFragment : Fragment() {

    var binding: FragmentSelectBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSelectBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnAlone3?.setOnClickListener {
            findNavController().navigate(R.id.action_selectFragment_to_aloneFragment)

        }
        binding?.btnBeginner3?.setOnClickListener {
            findNavController().navigate(R.id.action_selectFragment_to_beginnerFragment)

        }
        binding?.btnWithLover3?.setOnClickListener {
            findNavController().navigate(R.id.action_selectFragment_to_withloverFragment)

        }
        binding?.btnWithFriend3?.setOnClickListener {
            findNavController().navigate(R.id.action_selectFragment_to_withfriendFragment)

        }
        binding?.btnFamily3?.setOnClickListener {
            findNavController().navigate(R.id.action_selectFragment_to_withfamilyFragment)

        }
        binding?.btnExotic3?.setOnClickListener {
            findNavController().navigate(R.id.action_selectFragment_to_exoticFragment)

        }

        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_selectFragment_to_startFragment)
        }


    }


}