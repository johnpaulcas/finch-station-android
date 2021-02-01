package com.finchstation.android.repository.routes

import androidx.lifecycle.LiveData
import com.finchstation.android.db.dao.FinchStationRouteDao
import com.finchstation.android.db.dao.FinchStationStopDao
import com.finchstation.android.db.relations.FinchStationStopWithFinchStationRoutes

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
class RoutesRepositoryImpl(
    private val finchStationStopDao: FinchStationStopDao
) : RoutesRepository {

    override fun getStopRoutes(stopName: String): LiveData<FinchStationStopWithFinchStationRoutes> {
        return finchStationStopDao.getFinchStationStopWithFinchStationRoutes(stopName)
    }


}