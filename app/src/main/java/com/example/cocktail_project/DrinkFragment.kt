package com.example.cocktail_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktail_project.databinding.FragmentDrinkBinding
import com.example.cocktail_project.repository.Item
import com.example.cocktail_project.viewmodel.CocktailViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class DrinkFragment : Fragment() {



    private var _binding: FragmentDrinkBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        _binding = FragmentDrinkBinding.inflate(inflater)


        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val databas = Firebase.database
        val itemRef = databas.getReference("drink")
        val arraylist = ArrayList<Item>()

        binding.recdrink.setHasFixedSize(true)
        _binding?.recdrink?.layoutManager =  GridLayoutManager(context,3)
        _binding?.recdrink?.adapter = Adapter(arraylist)




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

                _binding?.recdrink?.adapter?.notifyDataSetChanged()
                //_binding?.recdrink?.adapter = Adapter(arraylist)
                //Adapter(arraylist).notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
            }

        })


    }



}