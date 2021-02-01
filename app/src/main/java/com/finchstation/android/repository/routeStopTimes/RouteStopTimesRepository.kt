package com.finchstation.android.repository.routeStopTimes

import androidx.lifecycle.LiveData
import com.finchstation.android.db.relations.FinchStationRouteWithFinchStationStopTimes

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
interface RouteStopTimesRepository {

    /**
     * Interface to get the routes stop time
     */
    fun getRouteStopTimes(fsrName: String): LiveData<FinchStationRouteWithFinchStationStopTimes>

}