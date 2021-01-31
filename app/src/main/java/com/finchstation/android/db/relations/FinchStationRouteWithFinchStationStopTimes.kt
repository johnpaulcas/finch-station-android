package com.finchstation.android.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
data class FinchStationRouteWithFinchStationStopTimes (
    @Embedded val finchStationRoute: FinchStationRoute,
    @Relation(
            parentColumn = "name",
            entityColumn = "fsr_key"
    )
    val finchStationStopTimes: List<FinchStationRouteStopTime>
)