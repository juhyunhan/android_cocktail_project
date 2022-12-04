package com.example.cocktail_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktail_project.databinding.FragmentDrinkBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DrinkFragment : Fragment() {


    private var _binding: FragmentDrinkBinding? = null
    private val binding get() = _binding!!
    //val databas = Firebase.database
    //val itemRef = databas.getReference("drink")
    //val arraylist = ArrayList<Item>()
    //var item = Item()
    //val viewModel : ItemViewModel by viewModels()

    //private lateinit var adapter: Adapter
    //private val viewModel by lazy { ViewModelProvider(this).get(CocktailViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?, ): View? {
        _binding = FragmentDrinkBinding.inflate(inflater)

        //recyclerView.layoutManager = layoutManager


        //var root_view = inflater.inflate(R.layout.fragment_drink, container, false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.recdrink.setHasFixedSize(true)


        //var item = Item()
        //val recyclerView = binding.recdrink
        //recyclerView.setHasFixedSize(true)
        //recyclerView.layoutManager = LinearLayoutManager(requireContext())

        /*itemRef.addValueEventListener(object : ValueEventListener {

            //@SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                arraylist.clear()
                for (snapshot: DataSnapshot in dataSnapshot.children) {
                    item = dataSnapshot.getValue<Item>()!!
                    //println(item.uu())
                    arraylist.add(item)
                }
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        })*/
        /*val datalist = arrayListOf(
            Item("aaafsgs"),
            Item("abb"),
            Item("accc"),
            Item("adddd"),
            Item("sagdga"),
            Item("asgs"),
            Item("asdgs"),
            Item("asdgs")
        )*/
        /*viewModel.modify3()

        viewModel.nameArray.observe(viewLifecycleOwner){

            _binding?.recdrink?.adapter?.notifyDataSetChanged()
        }
        _binding?.recdrink?.layoutManager =  LinearLayoutManager(context)
        _binding?.recdrink?.adapter = Adapter(viewModel.nameArray)
        //_binding?.recdrink?.adapter = Adapter(datalist)*/




        binding.recdrink.setHasFixedSize(true)
        _binding?.recdrink?.layoutManager = LinearLayoutManager(context)

        val databas = Firebase.database
        val itemRef = databas.getReference("drink")


        itemRef.addListenerForSingleValueEvent(object : ValueEventListener {

            //@SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //var item: Item
                //arraylist.clear()
                //var item: Item
                for (snapshot in dataSnapshot.children) {
                    //val item = snapshot.getValue<Item>()!!
                    //val item = Item("51759725981598")
                    //println(item.uu())
                    //arraylist.add(item)
                }
                //Adapter(arraylist).notifyDataSetChanged()
                //_binding?.recdrink?.adapter = Adapter(arraylist)
                //Adapter(arraylist).notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
            }

        })
        /*arraylist.add(Item("sssss"))
        arraylist.add(Item("sssss"))
        arraylist.add(Item("sssss"))
        arraylist.add(Item("sssss"))
        arraylist.add(Item("sssss"))
        arraylist.add(Item("sssss"))
        arraylist.add(Item("sssss"))
        arraylist.add(Item("sssss"))*/


        //_binding?.recdrink?.adapter = Adapter(arraylist)
        //Adapter(arraylist).notifyDataSetChanged()
        //_binding?.recdrink?.adapter = Adapter(arraylist)*/


        //recyclerView.adapter = Adapter(requireContext(),arraylist)
    }
}
/*override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}


}*/