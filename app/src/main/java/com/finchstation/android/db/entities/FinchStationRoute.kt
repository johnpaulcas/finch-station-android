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
@Entity(tableName = "finch_station_route")
@Parcelize
data class FinchStationRoute (

    // This will serve as foreign key to Finch Station
    @ColumnInfo(name="finch_station_key")
    var finchStationKey: String,

    @SerializedName("name")
    @Expose
    @PrimaryKey(autoGenerate = false)
    val name: String? = null,

    @SerializedName("uri")
    @Expose
    @ColumnInfo(name = "uri")
    val uri: String? = null,

    @SerializedName("stop_times")
    @Expose
    @ColumnInfo(name = "finch_station_route_stop_times")
    val finchStationRouteStopTimes: List<FinchStationRouteStopTime?>? = null,

    @SerializedName("route_group_id")
    @Expose
    @ColumnInfo(name = "route_group_id")
    val routeGroupId: String? = null

): Parcelable