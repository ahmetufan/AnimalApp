package com.ahmet.kotlinanimalapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Model2(
    @ColumnInfo(name = "hayvan_ismi")
    val hayvan_ismi: String?,

    @ColumnInfo(name = "veteriner")
    val veteriner: String?,

    @ColumnInfo(name = "yemek")
    val yemek: String?,

    @ColumnInfo(name = "temizlik")
    val temizlik: String?,

    @ColumnInfo(name = "sevgi")
    val sevgi: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

