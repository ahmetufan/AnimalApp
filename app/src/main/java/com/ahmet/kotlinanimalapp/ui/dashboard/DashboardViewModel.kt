package com.ahmet.kotlinanimalapp.ui.dashboard

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ahmet.kotlinanimalapp.BaseViewModel
import com.ahmet.kotlinanimalapp.service.AnimalDatabase
import com.ahmet.kotlinanimalapp.model.Model2
import kotlinx.coroutines.launch

class DashboardViewModel (application: Application): BaseViewModel(application) {

    val details=MutableLiveData<Model2>()

    fun getDetailRoom(id:Int) {

        launch {

            val dao= AnimalDatabase(getApplication()).animalDao2().getAnimal(id)

            details.value=dao

        }

    }
}