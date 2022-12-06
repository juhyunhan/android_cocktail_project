package com.example.cocktail_project.repository

import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.example.cocktail_project.RecipeFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class CocktailRepository {

    val databas = Firebase.database
    val cockRef = databas.getReference("cocktail")
    var cocktai = Cocktail()
    var naname = "chk_blueHawaii" // 선택x 기본값
    fun postCocktail(newvalue :String){
        naname = newvalue
    }
    fun observeCocktail(name: MutableLiveData<String>,a: MutableLiveData<String>,b: MutableLiveData<String>,c: MutableLiveData<String>,d: MutableLiveData<String>,p: MutableLiveData<String>,o: MutableLiveData<String>){
        cockRef.child(naname).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                cocktai = dataSnapshot.getValue<Cocktail>()!!
                name.value = cocktai.name()
                a.postValue(cocktai.aa())
                b.postValue(cocktai.bb())
                c.postValue(cocktai.cc())
                d.postValue(cocktai.dd())
                p.postValue(cocktai.pp())
                o.postValue(cocktai.oo())




            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
    }




}