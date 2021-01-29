package com.finchstation.android.db.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Entity(tableName = "finch_station_routes_stop_time")
@Parcelize
data class FinchStationRouteStopTime (

    // serve as foreign key
    @ColumnInfo(name = "finch_station_route_key")
    var finchStationRouteKey: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("service_id")
    @Expose
    @ColumnInfo(name = "service_id")
    val serviceId: Int? = null,

    @SerializedName("shape")
    @Expose
    @ColumnInfo(name = "shape")
    val shape: String? = null,

    @SerializedName("departure_time")
    @Expose
    @ColumnInfo(name = "departure_time")
    val departureTime: String? = null,

    @SerializedName("departure_timestamp")
    @Expose
    @ColumnInfo(name = "departure_timestamp")
    val departureTimestamp: Int? = null

): Parcelable