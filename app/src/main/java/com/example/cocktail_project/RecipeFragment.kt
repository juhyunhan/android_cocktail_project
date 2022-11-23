package com.example.cocktail_project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.cocktail_project.databinding.FragmentRecipeBinding
import com.example.cocktail_project.viewmodel.CocktailViewModel
import kotlinx.android.synthetic.main.fragment_recipe.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeFragment : Fragment() {

    val viewModel: CocktailViewModel by activityViewModels()
    var binding : FragmentRecipeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipeBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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



        binding?.buttonStart?.setOnClickListener {
            findNavController().navigate(R.id.action_recipeFragment_to_backgroundFragment)
        }

    }



}