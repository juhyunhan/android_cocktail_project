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
import com.example.cocktail_project.viewmodel.CocktailViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [aloneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class beginnerFragment : Fragment() {

    val viewModel: CocktailViewModel by activityViewModels()
    var binding: FragmentBeginnerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentBeginnerBinding.inflate(inflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chkBlueHawaii?.setOnClickListener {
            viewModel.set1(1)
            viewModel.modify2()
            findNavController().navigate(R.id.action_beginnerFragment_to_recipeFragment)

        }
        binding?.chkLemon?.setOnClickListener {
            viewModel.set1(5)
            viewModel.modify2()
            findNavController().navigate(R.id.action_beginnerFragment_to_recipeFragment)

        }
        binding?.chkPear?.setOnClickListener {
            viewModel.set1(6)
            viewModel.modify2()
            findNavController().navigate(R.id.action_beginnerFragment_to_recipeFragment)

        }
        binding?.chkStraw?.setOnClickListener {
            viewModel.set1(7)
            viewModel.modify2()
            findNavController().navigate(R.id.action_beginnerFragment_to_recipeFragment)

        }
        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_beginnerFragment_to_startFragment)
        }

        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_beginnerFragment_to_selectFragment)
        }


    }


}