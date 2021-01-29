package com.finchstation.android.db.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 */
class FinchStationRouteStopTime {

    @SerializedName("service_id")
    @Expose
    private var serviceId: Int? = null

    @SerializedName("shape")
    @Expose
    private var shape: String? = null

    @SerializedName("departure_time")
    @Expose
    private var departureTime: String? = null

    @SerializedName("departure_timestamp")
    @Expose
    private var departureTimestamp: Int? = null

    fun getServiceId(): Int? {
        return serviceId
    }

    fun setServiceId(serviceId: Int?) {
        this.serviceId = serviceId
    }

    fun getShape(): String? {
        return shape
    }

    fun setShape(shape: String?) {
        this.shape = shape
    }

    fun getDepartureTime(): String? {
        return departureTime
    }

    fun setDepartureTime(departureTime: String?) {
        this.departureTime = departureTime
    }

    fun getDepartureTimestamp(): Int? {
        return departureTimestamp
    }

    fun setDepartureTimestamp(departureTimestamp: Int?) {
        this.departureTimestamp = departureTimestamp
    }


}