package com.finchstation.android.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationStop

/**
 * @author johnpaulcas
 * @since 31/01/2021
 */
class FinchStationStopWithFinchStationRoutes (
    @Embedded val finchStationStop: FinchStationStop,
    @Relation(
            parentColumn = "name",
            entityColumn = "fs_stop_key"
    )
    val finchStationRoutes: List<FinchStationRoute>
)