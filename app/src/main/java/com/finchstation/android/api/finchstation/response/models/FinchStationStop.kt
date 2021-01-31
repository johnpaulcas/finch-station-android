package com.finchstation.android.api.finchstation.response.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
data class FinchStationStop (

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("uri")
    @Expose
    val uri: String? = null,

    @SerializedName("agency")
    @Expose
    val agency: String? = null,

    @SerializedName("routes")
    @Expose
    val routes: List<Route>? = null

)