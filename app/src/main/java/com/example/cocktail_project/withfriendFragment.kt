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
import com.example.cocktail_project.databinding.FragmentWithfriendBinding
import com.example.cocktail_project.databinding.FragmentWithloverBinding
import com.example.cocktail_project.viewmodel.CocktailViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [aloneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class withfriendFragment : Fragment() {
    val viewModel: CocktailViewModel by activityViewModels()
    var binding: FragmentWithfriendBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentWithfriendBinding.inflate(inflater)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.chkLemon?.setOnClickListener {
            viewModel.set1(5)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfriendFragment_to_recipeFragment)

        }
        binding?.chkMargarita?.setOnClickListener {
            viewModel.set1(13)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfriendFragment_to_recipeFragment)

        }
        binding?.chkSunrise?.setOnClickListener {
            viewModel.set1(14)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfriendFragment_to_recipeFragment)

        }
        binding?.chkPupple?.setOnClickListener {
            viewModel.set1(15)
            viewModel.modify2()
            findNavController().navigate(R.id.action_withfriendFragment_to_recipeFragment)

        }
        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_withfriendFragment_to_startFragment)
        }
        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_withfriendFragment_to_selectFragment)
        }


    }


}