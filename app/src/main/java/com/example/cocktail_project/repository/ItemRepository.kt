package com.example.cocktail_project.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class ItemRepository {

    lateinit var item: Item
    val databas = Firebase.database
    val itemRef = databas.getReference("drink")
    val arraylist = ArrayList<Item>()


    /*fun nameArray(array: MutableLiveData<ArrayList<Item>>) {

        itemRef.addValueEventListener(object : ValueEventListener {



            //@SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                arraylist.clear()
                //var item: Item
                for (snapshot: DataSnapshot in dataSnapshot.children) {
                    item = snapshot.getValue<Item>()!!
                    //println(item.uu())
                    arraylist.add(item)
                }
                //adapter.notifyDataSetChanged()
                array.postValue(arraylist)
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
        //return arraylist
    }*/
}