package com.finchstation.android.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime
import com.finchstation.android.db.relations.FinchStationRouteWithFinchStationRouteStopTimes

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

    @Query("SELECT * FROM finch_station_route WHERE name = :finchStationRouteName")
    suspend fun getFinchStationRouteWithFinchStationRouteStopTimes(
        finchStationRouteName: String
    ): List<FinchStationRouteWithFinchStationRouteStopTimes>

    @Query("SELECT * FROM finch_station_routes_stop_time WHERE finch_station_route_key = :finchStationRouteName")
    suspend fun getAllFinchStationRouteStopTimes(
        finchStationRouteName: String
    ): List<FinchStationRouteStopTime>

}