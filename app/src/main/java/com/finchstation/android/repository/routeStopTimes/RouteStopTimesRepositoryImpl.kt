package com.finchstation.android.repository.routeStopTimes

import androidx.lifecycle.LiveData
import com.finchstation.android.db.dao.FinchStationRouteDao
import com.finchstation.android.db.relations.FinchStationRouteWithFinchStationStopTimes

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
class RouteStopTimesRepositoryImpl(
    private val finchStationRouteDao: FinchStationRouteDao
): RouteStopTimesRepository {

    override fun getRouteStopTimes(
        fsrName: String
    ): LiveData<FinchStationRouteWithFinchStationStopTimes> {
        return finchStationRouteDao.getFinchStationRouteWithFinchStationStopTimes(fsrName)
    }
}