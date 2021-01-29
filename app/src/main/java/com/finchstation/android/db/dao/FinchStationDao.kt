package com.finchstation.android.db.dao

import androidx.room.*
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.relations.FinchStationWithFinchStationRoutes

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Dao
interface FinchStationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(finchStation: FinchStation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFinchStationRoute(finchStationRoute: FinchStationRoute)

    @Transaction
    @Query("SELECT * FROM finch_station WHERE name = :finchStationName")
    suspend fun getFinchStationWithFinchStationRoutes(finchStationName: String): List<FinchStationWithFinchStationRoutes>

    @Query("SELECT * FROM finch_station_route WHERE finch_station_key = :name")
    suspend fun getAllFinchStationRoute(name: String): List<FinchStationRoute>
}