package com.finchstation.android.db.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize


/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Entity(tableName = "finch_station_routes_stop_time")
@Parcelize
data class FinchStationRouteStopTime (

    // serve as foreign key (finch station route)
    @ColumnInfo(name = "fsr_key")
    var finchStationRouteKey: String,

    @ColumnInfo(name = "service_id")
    val serviceId: Int? = null,

    @ColumnInfo(name = "shape")
    val shape: String? = null,

    @ColumnInfo(name = "departure_time")
    val departureTime: String? = null,

    @ColumnInfo(name = "departure_timestamp")
    val departureTimestamp: Int? = null

): Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0 // auto generated id
}