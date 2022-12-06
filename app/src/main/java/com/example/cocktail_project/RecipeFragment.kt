package com.example.cocktail_project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.cocktail_project.databinding.FragmentRecipeBinding
import com.example.cocktail_project.viewmodel.CocktailViewModel
import kotlinx.android.synthetic.main.fragment_recipe.*
import java.util.Collections.list

class RecipeFragment : Fragment() {

    val viewModel: CocktailViewModel by activityViewModels()
    var binding : FragmentRecipeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipeBinding.inflate(inflater)

        viewModel.name.observe(viewLifecycleOwner){
            binding?.selectedCocktail?.text = viewModel.name.value
        }
        viewModel.a.observe(viewLifecycleOwner){
            binding?.recipea?.text = viewModel.a.value
        }
        viewModel.b.observe(viewLifecycleOwner){
            binding?.recipeb?.text = viewModel.b.value
        }
        viewModel.c.observe(viewLifecycleOwner){
            binding?.recipec?.text = viewModel.c.value
        }
        viewModel.d.observe(viewLifecycleOwner){
            binding?.reciped?.text = viewModel.d.value
        }
        viewModel.p.observe(viewLifecycleOwner){
            Glide.with(this)
                .load(viewModel.p.value)
                .into(image_cocktail)
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnStart?.setOnClickListener {
//            val result = "testdata"
            var cocktail_element = ArrayList<String>()
            cocktail_element.add(viewModel.a.value.toString())
            cocktail_element.add(viewModel.b.value.toString())
            cocktail_element.add(viewModel.c.value.toString())
            cocktail_element.add(viewModel.d.value.toString())
            cocktail_element.add(viewModel.name.value.toString())
            cocktail_element.add(viewModel.p.value.toString())
            val bundle = bundleOf("recipe2background" to cocktail_element)
            findNavController().navigate(R.id.action_recipeFragment_to_backgroundFragment, bundle)
        }
        binding?.btnHome?.setOnClickListener {
            findNavController().navigate(R.id.action_recipeFragment_to_startFragment)
        }
        binding?.btnBack?.setOnClickListener {
            findNavController().navigate(R.id.action_recipeFragment_to_selectFragment)
        }
    }



}