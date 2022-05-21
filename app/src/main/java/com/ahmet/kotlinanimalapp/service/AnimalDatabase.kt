package com.ahmet.kotlinanimalapp.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ahmet.kotlinanimalapp.model.Model2

@Database(entities = [Model2::class], version = 1)
abstract class AnimalDatabase:RoomDatabase() {

    abstract fun animalDao2(): AnimalDao

    companion object {

        @Volatile private var instance: AnimalDatabase?=null

        private val lock=Any()

        operator fun invoke(context:Context)= instance ?: synchronized(lock) {

            instance ?: makeDatabase(context).also {
                instance =it
            }
        }

        private fun makeDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext, AnimalDatabase::class.java,"animaldatabase").build()
    }
}