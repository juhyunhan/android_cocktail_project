package com.example.cocktail_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

class ShakeFragment : Fragment() {

    lateinit var result : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        result = arguments?.getStringArrayList("background2shake") as ArrayList<String>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root_view = inflater.inflate(R.layout.fragment_shake, container, false)
        val gif_show = root_view.findViewById<ImageView>(R.id.shake_view)
        val gif_source = R.drawable.shake_sy
        Glide.with(this)
            .load(gif_source)
            .into(gif_show)

        val resultbutton = root_view.findViewById<Button>(R.id.result_btn)
        resultbutton.setOnClickListener {
            val success = result.get(0) //t/f
            Log.d("ON SHAKE", success)

            val final_result = ArrayList<String>()
            final_result.add(result.get(1)) //name data
            final_result.add(result.get(2)) //firebase data
            val bundle = bundleOf("final" to final_result)
            if (success == "True"){
                findNavController().navigate(R.id.action_shakeFragment_to_successFragment, bundle)
            }

            else {
                findNavController().navigate(R.id.action_shakeFragment_to_failFragment)
            }
        }
        return root_view
    }


}