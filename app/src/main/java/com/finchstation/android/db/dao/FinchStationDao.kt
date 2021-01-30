package com.finchstation.android.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.relations.FinchStationWithFinchStationStop

/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
@Dao
interface FinchStationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(finchStation: FinchStation)

    @Query("SELECT * FROM finch_station WHERE name=:finchStationName")
    suspend fun getFinchStationWithFinchStationStop(
            finchStationName: String?
    ): List<FinchStationWithFinchStationStop>

}