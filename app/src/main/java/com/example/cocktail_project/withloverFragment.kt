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
import com.example.cocktail_project.databinding.FragmentWithfamilyBinding
import com.example.cocktail_project.databinding.FragmentWithloverBinding
import com.example.cocktail_project.viewmodel.CocktailViewModel


class withloverFragment : Fragment() {
    val viewModel: CocktailViewModel by activityViewModels()
    var binding: FragmentWithloverBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentWithloverBinding.inflate(inflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chkApple?.setOnClickListener {
            viewModel.set1(16)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withloverFragment_to_recipeFragment)

        }
        binding?.chkMojito?.setOnClickListener {
            viewModel.set1(18)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withloverFragment_to_recipeFragment)

        }
        binding?.chkBlueHawaii?.setOnClickListener {
            viewModel.set1(1)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withloverFragment_to_recipeFragment)

        }
        binding?.chkMidori?.setOnClickListener {
            viewModel.set1(17)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withloverFragment_to_recipeFragment)

        }
        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_withloverFragment_to_startFragment)
        }
        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_withloverFragment_to_selectFragment)
        }


    }


}