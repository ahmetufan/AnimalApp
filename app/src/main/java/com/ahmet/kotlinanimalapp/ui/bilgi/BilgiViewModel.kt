package com.ahmet.kotlinanimalapp.ui.bilgi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BilgiViewModel:ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Bilgi Fragment"
    }
    val text: LiveData<String> = _text
}