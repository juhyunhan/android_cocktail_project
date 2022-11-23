package com.example.cocktail_project

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.cocktail_project.databinding.FragmentAlcholBinding
import com.example.cocktail_project.databinding.FragmentDrinkBinding

class DrinkFragment : Fragment() {

    private var _binding: FragmentDrinkBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        _binding = FragmentDrinkBinding.inflate(inflater, container, false)

        var root_view = inflater.inflate(R.layout.fragment_drink, container, false)
        // Inflate the layout for this fragment
        return root_view
    }

}