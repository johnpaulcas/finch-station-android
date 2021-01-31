package com.finchstation.android.db.entities

import android.os.Parcelable
import androidx.room.*
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Entity(tableName = "finch_station_route")
@Parcelize
data class FinchStationRoute (

    // This will serve as foreign key to Finch Station
    @ColumnInfo(name="fs_stop_key")
    val finchStationKey: String,

    @PrimaryKey(autoGenerate = false)
    val name: String,

    @ColumnInfo(name = "uri")
    val uri: String? = null,

): Parcelable