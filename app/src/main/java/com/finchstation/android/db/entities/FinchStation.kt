package com.finchstation.android.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


/**
 * @author johnpaulcas
 * @since 30/01/2021
 */
@Entity(tableName = "finch_station")
data class FinchStation(

        @SerializedName("name")
        @Expose
        @PrimaryKey(autoGenerate = false)
        private val name: String? = null,

        @SerializedName("time")
        @Expose
        private val time: Int? = null,

        @SerializedName("stops")
        @Expose
        private val stops: List<FinchStationStop>? = null,

        @SerializedName("uri")
        @Expose
        private val uri: String? = null

)