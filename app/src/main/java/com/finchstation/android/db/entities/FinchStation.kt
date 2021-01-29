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
@Entity(tableName = "finch_station")
@Parcelize
data class FinchStation (

    @SerializedName("name")
    @Expose
    @PrimaryKey(autoGenerate = false)
    val name: String? = null,

    @SerializedName("uri")
    @Expose
    @ColumnInfo(name = "uri")
    val uri: String? = null,

    @SerializedName("agency")
    @Expose
    @ColumnInfo(name = "agency")
    val agency: String? = null,

    @SerializedName("routes")
    @Expose
    @ColumnInfo(name = "routes")
    val routes: List<FinchStationRoute?>? = null

): Parcelable