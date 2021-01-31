package com.finchstation.android.api.finchstation

import androidx.lifecycle.LiveData
import com.finchstation.android.api.ApiResponse
import com.finchstation.android.api.finchstation.response.FinchStationResponse
import com.finchstation.android.db.entities.FinchStation
import retrofit2.http.GET

/**
 * @author johnpaulcas
 * @since 30/01/2021
 */
interface FinchStationService {

    @GET("/finch_station.json")
    fun getFinchStation(): LiveData<ApiResponse<FinchStationResponse>>

}