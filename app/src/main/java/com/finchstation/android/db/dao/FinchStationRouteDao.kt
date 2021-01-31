package com.finchstation.android.db.dao

import androidx.room.*
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Dao
interface FinchStationRouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(finchStationRoute: FinchStationRoute)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFinchStationStopTime(finchStationStopTime: FinchStationRouteStopTime)

//    @Transaction
//    @Query("SELECT * FROM finch_station_route WHERE name = :finchStationRouteName")
//    suspend fun getFinchStationRouteWithFinchStationRouteStopTimes(
//        finchStationRouteName: String
//    ): List<FinchStationRouteWithFinchStationRouteStopTimes>

    @Query("SELECT * FROM finch_station_routes_stop_time WHERE finch_station_route_key = :finchStationRouteName")
    suspend fun getAllFinchStationRouteStopTimes(
        finchStationRouteName: String
    ): List<FinchStationRouteStopTime>

}