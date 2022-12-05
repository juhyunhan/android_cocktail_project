package com.example.cocktail_project

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.cocktail_project.databinding.FragmentAlcholBinding
import com.example.cocktail_project.databinding.FragmentDrinkBinding
import com.example.cocktail_project.repository.Item
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_alchol.*
import kotlinx.android.synthetic.main.fragment_recipe.*


class AlcholFragment : Fragment() {

    private var _binding: FragmentAlcholBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        //var root_view = inflater.inflate(R.layout.fragment_alchol, container, false)
        _binding = FragmentAlcholBinding.inflate(inflater)


        return _binding?.root
        /*var card_view = root_view.findViewById<CardView>(R.id.alchol_cardview_1)
//        for card in car_views:
//            card.apply{
//
//                ...
//            }
        card_view.apply{
            setOnLongClickListener { v ->
                // Create a new ClipData.
                // This is done in two steps to provide clarity. The convenience method
                // ClipData.newPlainText() can create a plain text ClipData in one step.

                // Create a new ClipData.Item from the ImageView object's tag.
                val item = ClipData.Item(v.tag as? CharSequence)

                // Create a new ClipData using the tag as a label, the plain text MIME type, and
                // the already-created item. This creates a new ClipDescription object within the
                // ClipData and sets its MIME type to "text/plain".
                val dragData = ClipData(
                    v.tag as? CharSequence,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item)

                // Instantiate the drag shadow builder.
                val myShadow = MyDragShadowBuilder(this)

                // Start the drag.
                v.startDragAndDrop(dragData,  // The data to be dragged
                    myShadow,  // The drag shadow builder
                    null,      // No need to use local data
                    0          // Flags (not currently used, set to 0)
                )

                // Indicate that the long-click was handled.
                true
            }

        }
        // Inflate the layout for this fragment

        /*val database = Firebase.database
        val myRef = database.getReference("base")
        //var base: String = "aa"

        val postListener = object : ValueEventListener {
            //private lateinit var textView: TextView
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI

                val base = dataSnapshot.getValue<String>()!!
                Glide.with(this@AlcholFragment)
                    .load(base)
                    .into(b1)

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message

            }
        }
        myRef.addValueEventListener(postListener)*/

        return root_view
    }*/
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val databas = Firebase.database
        val itemRef = databas.getReference("base")
        val arraylist = ArrayList<Item>()

        binding.recbase.setHasFixedSize(true)
        _binding?.recbase?.layoutManager =  GridLayoutManager(context,3)
        _binding?.recbase?.adapter = Adapter(arraylist)




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

                _binding?.recbase?.adapter?.notifyDataSetChanged()
                //_binding?.recdrink?.adapter = Adapter(arraylist)
                //Adapter(arraylist).notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
            }

        })


    }
}