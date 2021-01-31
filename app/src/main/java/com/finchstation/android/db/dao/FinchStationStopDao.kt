package com.finchstation.android.db.dao

import androidx.room.*
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.db.entities.FinchStationRoute

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Dao
interface FinchStationStopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(finchStationStop: FinchStationStop)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFinchStationRoute(finchStationRoute: FinchStationRoute)

//    @Transaction
//    @Query("SELECT * FROM finch_station_stop WHERE name = :finchStationStopName")
//    suspend fun getFinchStationStopWithFinchStationRoutes(
//            finchStationStopName: String
//    ): List<FinchStationStopWithFinchStationRoutes>

    @Query("SELECT * FROM finch_station_route WHERE finch_station_key = :name")
    suspend fun getAllFinchStationRoute(name: String): List<FinchStationRoute>
}