package com.example.cocktail_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShakeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShakeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
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
        var shakebutton = root_view.findViewById<Button>(R.id.result_btn)
        shakebutton.setOnClickListener {
            var success = result.get(0)
            Log.d("ON SHAKE", success)

            var final_result = ArrayList<String>()
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShakeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShakeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}