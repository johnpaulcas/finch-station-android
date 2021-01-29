package com.fitchstation.android.db.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 */
class FinchStation {
    @SerializedName("uri")
    @Expose
    private var uri: String? = null

    @SerializedName("agency")
    @Expose
    private var agency: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("routes")
    @Expose
    private var routes: List<FinchStationRoute?>? = null

    fun getUri(): String? {
        return uri
    }

    fun setUri(uri: String?) {
        this.uri = uri
    }

    fun getAgency(): String? {
        return agency
    }

    fun setAgency(agency: String?) {
        this.agency = agency
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getRoutes(): List<FinchStationRoute?>? {
        return routes
    }

    fun setRoutes(routes: List<FinchStationRoute?>?) {
        this.routes = routes
    }

}