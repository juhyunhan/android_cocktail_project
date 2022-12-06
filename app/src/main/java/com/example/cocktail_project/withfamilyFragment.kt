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
import com.example.cocktail_project.viewmodel.CocktailViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [aloneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class withfamilyFragment : Fragment() {

    val viewModel: CocktailViewModel by activityViewModels()
    var binding: FragmentWithfamilyBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentWithfamilyBinding.inflate(inflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chkWater?.setOnClickListener {
            viewModel.set1(8)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfamilyFragment_to_recipeFragment)

        }
        binding?.chkStraw?.setOnClickListener {
            viewModel.set1(7)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfamilyFragment_to_recipeFragment)

        }
        binding?.chkPear?.setOnClickListener {
            viewModel.set1(6)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfamilyFragment_to_recipeFragment)

        }
        binding?.chkStrawmoji?.setOnClickListener {
            viewModel.set1(12)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfamilyFragment_to_recipeFragment)

        }
        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_withfamilyFragment_to_startFragment)
        }
        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_withfamilyFragment_to_selectFragment)
        }


    }


}