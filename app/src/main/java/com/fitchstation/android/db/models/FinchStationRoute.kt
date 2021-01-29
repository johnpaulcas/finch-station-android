package com.fitchstation.android.db.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 */
class FinchStationRoute {
    @SerializedName("uri")
    @Expose
    private var uri: String? = null

    @SerializedName("stop_times")
    @Expose
    private var finchStationRouteStopTimes: List<FinchStationRouteStopTime?>? = null

    @SerializedName("route_group_id")
    @Expose
    private var routeGroupId: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getUri(): String? {
        return uri
    }

    fun setUri(uri: String?) {
        this.uri = uri
    }

    fun getStopTimes(): List<FinchStationRouteStopTime?>? {
        return finchStationRouteStopTimes
    }

    fun setStopTimes(finchStationRouteStopTimes: List<FinchStationRouteStopTime?>?) {
        this.finchStationRouteStopTimes = finchStationRouteStopTimes
    }

    fun getRouteGroupId(): String? {
        return routeGroupId
    }

    fun setRouteGroupId(routeGroupId: String?) {
        this.routeGroupId = routeGroupId
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }
}