package com.finchstation.android.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@Dao
interface FinchStationRouteStopTimeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stopTime: FinchStationRouteStopTimeDao)

}