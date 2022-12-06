package com.example.cocktail_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cocktail_project.databinding.FragmentAloneBinding
import com.example.cocktail_project.databinding.FragmentBeginnerBinding
import com.example.cocktail_project.databinding.FragmentExoticBinding
import com.example.cocktail_project.viewmodel.CocktailViewModel

class exoticFragment : Fragment() {

    val viewModel: CocktailViewModel by activityViewModels()
    var binding: FragmentExoticBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentExoticBinding.inflate(inflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chkWater?.setOnClickListener {
            viewModel.set1(8)
            viewModel.modify2()
            findNavController().navigate(R.id.action_exoticFragment_to_recipeFragment)

        }
        binding?.chkBloody?.setOnClickListener {
            viewModel.set1(9)
            viewModel.modify2()
            findNavController().navigate(R.id.action_exoticFragment_to_recipeFragment)

        }
        binding?.chkOld?.setOnClickListener {
            viewModel.set1(10)
            viewModel.modify2()
            findNavController().navigate(R.id.action_exoticFragment_to_recipeFragment)

        }
        binding?.chkSexonthe?.setOnClickListener {
            viewModel.set1(11)
            viewModel.modify2()
            findNavController().navigate(R.id.action_exoticFragment_to_recipeFragment)

        }
        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_exoticFragment_to_startFragment)
        }

        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_exoticFragment_to_selectFragment)
        }


    }


}