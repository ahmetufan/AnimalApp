package com.ahmet.kotlinanimalapp.model

import com.ahmet.kotlinanimalapp.R
import java.io.Serializable

class Model(var name:String,var image:Int,var veteriner:String,var yemek:String,
            var temizlik:String,var sevgi:String) :Serializable{
}
