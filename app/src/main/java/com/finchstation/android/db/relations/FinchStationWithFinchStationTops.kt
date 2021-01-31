package com.finchstation.android.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.entities.FinchStationStop

/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
data class FinchStationWithFinchStationTops (
    @Embedded val finchStation: FinchStation,
    @Relation(
        parentColumn = "name", // primary key of FinchStation
        entityColumn = "fs_key" // FinchStationRoute foreign key
    )
    val finchStationStops: List<FinchStationStop>
)