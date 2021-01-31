package com.finchstation.android.db.entities

import androidx.room.*
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


/**
 * @author johnpaulcas
 * @since 30/01/2021
 */
@Entity(tableName = "finch_station")
data class FinchStation(

    @PrimaryKey(autoGenerate = false)
    val name: String,

    @ColumnInfo(name = "time")
    val time: Int? = null,

    @ColumnInfo(name="uri")
    val uri: String? = null

)