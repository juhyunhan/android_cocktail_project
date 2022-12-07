package com.example.cocktail_project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.cocktail_project.databinding.FragmentSuccessBinding
import com.example.cocktail_project.viewmodel.CocktailViewModel
import kotlinx.android.synthetic.main.fragment_recipe.*
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment : Fragment() {
    val binding : FragmentSuccessBinding? = null
    //lateinit var result : ArrayList<String>
    val viewModel: CocktailViewModel by activityViewModels()
    var comment : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //result = arguments?.getStringArrayList("final") as ArrayList<String>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root_view = inflater.inflate(R.layout.fragment_success, container, false)

        /*val final_img = root_view.findViewById<ImageView>(R.id.chk_pear)
        Glide.with(this)
            .load(result.get(1).toUri()) //firebase url
            .into(final_img)*/

        /*val final_text = root_view.findViewById<TextView>(R.id.tasty_content)
        final_text.setText(result.get(0))*/
        //칵테일 이름
        comment = root_view.findViewById<TextView>(R.id.tasty_content)
        return root_view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnLastHome?.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_startFragment)
        }
        viewModel.o.observe(viewLifecycleOwner){
            comment?.text = viewModel.o.value
        }
        viewModel.p.observe(viewLifecycleOwner){
            Glide.with(this)
                .load(viewModel.p.value)
                .into(chk_pear)
        }

    }
}