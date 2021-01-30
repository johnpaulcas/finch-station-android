package com.finchstation.android.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.entities.FinchStationStop

/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
data class FinchStationWithFinchStationStop (
    @Embedded val finchStation: FinchStation,
    @Relation(
            parentColumn = "name",
            entityColumn = "finch_station_key"
    )
    val finchStationStops: List<FinchStationStop>
)