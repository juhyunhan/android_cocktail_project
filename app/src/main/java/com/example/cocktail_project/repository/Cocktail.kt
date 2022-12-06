package com.example.cocktail_project.repository

import android.net.Uri
class Cocktail (
    var name: String = "name",
    var a: String = "g",
    var b: String = "h",
    var c: String = "j",
    var d: String? = null,
    var profile: String? = null,
    var comment: String? = null

){
    fun aa(): String {
        return a
    }
    fun bb(): String {
        return b
    }
    fun cc(): String {
        return c
    }
    fun dd(): String? {
        return d
    }
    fun name(): String {
        return name
    }
    fun pp(): String? {
        return profile
    }
    fun oo(): String? {
        return comment
    }


}