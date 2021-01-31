package com.finchstation.android.api.finchstation.response.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
data class Route (

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("uri")
    @Expose
    val uri: String?,

    @SerializedName("stop_times")
    @Expose
    val stopTimes: List<RouteStopTime>?,

    @SerializedName("route_group_id")
    @Expose
    val routeGroupId: String?,

)