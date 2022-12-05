package com.example.cocktail_project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_recipe.*
import kotlinx.android.synthetic.main.fragment_success.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SuccessFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuccessFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var result : ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        result = arguments?.getStringArrayList("final") as ArrayList<String>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root_view = inflater.inflate(R.layout.fragment_success, container, false)

        val final_img = root_view.findViewById<ImageView>(R.id.chk_pear)
        Glide.with(this)
            .load(result.get(1).toUri()) //firebase url
            .into(final_img)

        val final_text = root_view.findViewById<TextView>(R.id.tasty_content)
        final_text.setText(result.get(0))

        return root_view
    }
}