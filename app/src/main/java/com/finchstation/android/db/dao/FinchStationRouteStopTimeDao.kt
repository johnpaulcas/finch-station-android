package com.finchstation.android.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.finchstation.android.db.entities.FinchStationRouteStopTime

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Dao
interface FinchStationRouteStopTimeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stopTime: FinchStationRouteStopTime)

    @Query("DELETE FROM finch_station_routes_stop_time")
    fun deleteAll()

    @Transaction
    @Query("SELECT * FROM finch_station_routes_stop_time WHERE fsr_key=:fsrKey")
    fun getAllFinchStationRouteStopTimes(fsrKey: String): LiveData<List<FinchStationRouteStopTime>>

}