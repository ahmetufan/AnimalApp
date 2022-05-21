package com.ahmet.kotlinanimalapp.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ahmet.kotlinanimalapp.model.Model2

@Dao
interface AnimalDao {

    @Query("SELECT * FROM model2")
    suspend fun getAllAnimal(): List<Model2>

    @Query("SELECT * FROM model2 WHERE id= :id")
    suspend fun getAnimal(id:Int): Model2

    @Insert
    suspend fun insertAll(model2: Array<Model2>):List<Long>

    @Query("DELETE FROM model2")
    suspend fun deleteAnimal()
}