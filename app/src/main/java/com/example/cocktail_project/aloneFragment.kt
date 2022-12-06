package com.example.cocktail_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cocktail_project.databinding.FragmentAloneBinding
import com.example.cocktail_project.viewmodel.CocktailViewModel


class aloneFragment : Fragment() {

    val viewModel: CocktailViewModel by activityViewModels()
    var binding: FragmentAloneBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAloneBinding.inflate(inflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chkBlueHawaii?.setOnClickListener {
            viewModel.set1(1)
            viewModel.modify2()
            findNavController().navigate(R.id.action_aloneFragment_to_recipeFragment)

        }
        binding?.chkLongIslandTea?.setOnClickListener {
            viewModel.set1(2)
            viewModel.modify2()
            findNavController().navigate(R.id.action_aloneFragment_to_recipeFragment)

        }
        binding?.chkTropical?.setOnClickListener {
            viewModel.set1(3)
            viewModel.modify2()
            findNavController().navigate(R.id.action_aloneFragment_to_recipeFragment)

        }
        binding?.chkWhiteLady?.setOnClickListener {
            viewModel.set1(4)
            viewModel.modify2()
            findNavController().navigate(R.id.action_aloneFragment_to_recipeFragment)

        }
        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_aloneFragment_to_startFragment)
        }
        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_aloneFragment_to_selectFragment)
        }


    }


}