package com.finchstation.android.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.relations.FinchStationStopWithFinchStationRoutes

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Dao
interface FinchStationStopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(finchStationStop: FinchStationStop)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFinchStationRoute(finchStationRoute: FinchStationRoute)

    @Transaction
    @Query("SELECT * FROM finch_station_route WHERE fs_stop_key=:name")
    fun getAllFinchStationRoute(name: String): LiveData<List<FinchStationRoute>>

    @Transaction
    @Query("SELECT * FROM finch_station_stop WHERE name=:fsStopKey")
    fun getFinchStationStopWithFinchStationRoutes(
            fsStopKey: String
    ): LiveData<FinchStationStopWithFinchStationRoutes>
}