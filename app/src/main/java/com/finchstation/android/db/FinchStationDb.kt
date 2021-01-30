package com.finchstation.android.db

import androidx.room.Database
import com.finchstation.android.db.dao.FinchStationDao
import com.finchstation.android.db.dao.FinchStationRouteDao
import com.finchstation.android.db.dao.FinchStationRouteStopTimeDao
import com.finchstation.android.db.dao.FinchStationStopDao
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime
import com.finchstation.android.db.entities.FinchStationStop

/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
@Database(
        entities = [
            FinchStation::class,
            FinchStationStop::class,
            FinchStationRoute::class,
            FinchStationRouteStopTime::class
        ],
        version = 1,
        exportSchema = false
)
abstract class FinchStationDb {

    abstract fun finchStationDao(): FinchStationDao

    abstract fun finchStationStopDao(): FinchStationStopDao

    abstract fun finchStationRouteDao(): FinchStationRouteDao

    abstract fun finchStationRouteStopTimeDao(): FinchStationRouteStopTimeDao

}