package com.finchstation.android.repository.routes

import androidx.lifecycle.LiveData
import com.finchstation.android.db.relations.FinchStationStopWithFinchStationRoutes

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
interface RoutesRepository {

    fun getStopRoutes(stopName: String): LiveData<FinchStationStopWithFinchStationRoutes>

}