package com.finchstation.android.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime
import com.finchstation.android.db.relations.FinchStationRouteWithFinchStationStopTimes
import retrofit2.http.GET

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Dao
interface FinchStationRouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(finchStationRoute: FinchStationRoute)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRouteTimeStop(routeTimesStop: FinchStationRouteStopTime)

    @Transaction
    @Query("SELECT * FROM finch_station_route WHERE name=:fsrName")
    fun getFinchStationRouteWithFinchStationStopTimes(
            fsrName: String
    ): LiveData<FinchStationRouteWithFinchStationStopTimes>

}