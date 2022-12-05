package com.example.cocktail_project

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cocktail_project.databinding.FragmentDrinkBinding
import com.example.cocktail_project.databinding.FragmentGarnishBinding
import com.example.cocktail_project.repository.Item
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class GarnishFragment : Fragment() {
    private var _binding: FragmentGarnishBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        //var root_view = inflater.inflate(R.layout.fragment_garnish, container, false)
        _binding = FragmentGarnishBinding.inflate(inflater)


        return _binding?.root
        // Inflate the layout for this fragment
        //return root_view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val databas = Firebase.database
        val itemRef = databas.getReference("garnish")
        val arraylist = ArrayList<Item>()

        binding.recgarnish.setHasFixedSize(true)
        _binding?.recgarnish?.layoutManager =  GridLayoutManager(context,3)
        _binding?.recgarnish?.adapter = Adapter(arraylist)




        itemRef.addListenerForSingleValueEvent(object : ValueEventListener {

            //@SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //var item: Item
                //arraylist.clear()
                //var item: Item
                for (snapshot in dataSnapshot.children) {
                    val item = snapshot.getValue<Item>()!!
                    //val item = Item("51759725981598")
                    //println(item.uu())
                    arraylist.add(item)
                }

                _binding?.recgarnish?.adapter?.notifyDataSetChanged()
                //_binding?.recdrink?.adapter = Adapter(arraylist)
                //Adapter(arraylist).notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
            }

        })


    }
}

