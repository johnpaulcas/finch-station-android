package com.finchstation.android.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.db.relations.FinchStationWithFinchStationTops

/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
@Dao
interface FinchStationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(finchStation: FinchStation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFinchStationStop(finchStationStop: FinchStationStop)

    @Transaction
    @Query("SELECT * FROM finch_station WHERE name=:name ")
    fun getAll(name: String): LiveData<FinchStation>

    @Transaction
    @Query("SELECT * FROM finch_station WHERE name=:finchStationName")
    fun getFinchStationWithFinchStationStops(finchStationName: String): LiveData<FinchStationWithFinchStationTops>

}