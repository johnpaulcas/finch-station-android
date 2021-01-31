package com.finchstation.android.api.finchstation.response

import com.finchstation.android.api.finchstation.response.models.FinchStationStop
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
data class FinchStationResponse (

    @SerializedName("name")
    @Expose
    private val name: String? = null,

    @SerializedName("time")
    @Expose
    private val time: Int? = null,

    @SerializedName("stops")
    @Expose
    private val finchStationStops: List<FinchStationStop>? = null,

    @SerializedName("uri")
    @Expose
    private val uri: String? = null

)