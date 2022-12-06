package com.example.cocktail_project.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktail_project.repository.CocktailRepository

const val UNCHECKED_COCKTAIL = "nothing"
class CocktailViewModel: ViewModel() {



    //var newvalue = "bb"
    //public val cocktail = Cocktail
    //val cocktail: Cocktail
    //private val _a = MutableLiveData<String>("${cocktai.aa()}")
    //val a : LiveData<String>get() = _a
    //private val _cocktail = MutableLiveData<Cocktail>()
    //val cocktail : LiveData<Cocktail>get() = _cocktail
    //val cocktai = Cocktail()
    private val _id = MutableLiveData<String>("0")
    val id : LiveData<String>get() = _id
    private val _name = MutableLiveData<String>("name")
    val name : LiveData<String>get() = _name
    private val _a = MutableLiveData<String>("1")
    val a : LiveData<String>get() = _a
    private val _b = MutableLiveData<String>("2")
    val b : LiveData<String>get() = _b
    private val _c = MutableLiveData<String>("3")
    val c : LiveData<String>get() = _c
    private val _d = MutableLiveData<String>("4")
    val d : LiveData<String>get() = _d
    private val _p = MutableLiveData<String>("5")
    val p : LiveData<String>get() = _p
    private val _o = MutableLiveData<String>("6")
    val o : LiveData<String>get() = _o
    private val repository = CocktailRepository()
    fun modify2(){
        repository.observeCocktail(_name,_a,_b,_c,_d,_p,_o)
    }

    private fun modify(cockname: String){

        _id.value = _id.value?.let { cockname } ?: UNCHECKED_COCKTAIL
        repository.postCocktail(_id.value ?: UNCHECKED_COCKTAIL)
    }

    fun set1(x : Int?) {
        when(x){
            1 -> modify("chk_blueHawaii")
            2 -> modify("chk_longIslandTea")
            3 -> modify("chk_tropical")
            4 -> modify("chk_whiteLady")
            5 -> modify("chk_lemon")
            6 -> modify("chk_pear")
            7 -> modify("chk_straw")
            8 -> modify("chk_water")
            9 -> modify("chk_bloody")
            10 -> modify("chk_old")
            11 -> modify("chk_sexonthe")
            12 -> modify("chk_strawmoji")
            13 -> modify("chk_margarita")
            14 -> modify("chk_purple")
            15 -> modify("chk_sunrise")
            16 -> modify("chk_apple")
            17 -> modify("chk_midori")
            18 -> modify("chk_mojito")

        }

    }

}