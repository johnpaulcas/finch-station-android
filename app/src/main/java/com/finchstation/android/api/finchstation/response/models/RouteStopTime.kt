package com.finchstation.android.api.finchstation.response.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
data class RouteStopTime (

    @SerializedName("service_id")
    @Expose
    val serviceId: Int? = null,

    @SerializedName("shape")
    @Expose
    val shape: String? = null,

    @SerializedName("departure_time")
    @Expose
    val departureTime: String? = null,

    @SerializedName("departure_timestamp")
    @Expose
    val departureTimestamp: Int? = null

)