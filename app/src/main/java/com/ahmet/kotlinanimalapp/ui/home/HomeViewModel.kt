package com.ahmet.kotlinanimalapp.ui.home

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ahmet.kotlinanimalapp.BaseViewModel
import com.ahmet.kotlinanimalapp.service.AnimalDatabase
import com.ahmet.kotlinanimalapp.model.Model2
import com.ahmet.kotlinanimalapp.service.ModelAPIService
import com.ahmet.kotlinanimalapp.preferences.CustomSharedPreferences
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application) {
    private val animalService= ModelAPIService()
    private val compositDisposable=CompositeDisposable()
    private var customPreferences =CustomSharedPreferences(getApplication())
    private var refreshTime = 10 * 60 * 1000 * 1000 * 1000L

    val animals=MutableLiveData<List<Model2>> ()


    fun refreshData() {

        val updateTime = customPreferences.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            getDataFromSQLite()

            Toast.makeText(getApplication(), "SQLite", Toast.LENGTH_SHORT).show()
        } else {

            getDataFromAPI()
            Toast.makeText(getApplication(), "API", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDataFromAPI() {

        compositDisposable.add(animalService.getAPI()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Model2>>() {
                override fun onSuccess(t: List<Model2>) {
                    storeInSQLite(t)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
        )

    }
    private fun storeInSQLite(list: List<Model2>) {
        launch {
            val dao= AnimalDatabase(getApplication()).animalDao2()
            dao.deleteAnimal()
            val listLong= dao.insertAll(*list.toTypedArray())
            var i=0
            while (i< list.size) {
                list[i].id=listLong[i].toInt()
                i++
            }
            showValue(list)
        }
        customPreferences.saveTime(System.nanoTime())
    }

    private fun getDataFromSQLite() {

        launch {

            val roomData= AnimalDatabase(getApplication()).animalDao2().getAllAnimal()
            showValue(roomData)
            Toast.makeText(getApplication(), "SQLite", Toast.LENGTH_SHORT).show()
        }

    }


    private fun showValue(animalListe: List<Model2>)  {
        animals.value=animalListe
    }


    override fun onCleared() {
        super.onCleared()
        compositDisposable.clear()
    }

}