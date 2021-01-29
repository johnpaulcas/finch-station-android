package com.finchstation.android.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.entities.FinchStationRoute

/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 * <p>
 *    Relation between FinchStation and FinchStationRoutes
 *    1 to N relationship
 *
 *    This model will join the finch_station and finch_station_route table
 * </p>
 *
 * @see FinchStation
 * @see FinchStationRoute
 */
data class FinchStationWithFinchStationRoutes(
    @Embedded val finchStation: FinchStation,
    @Relation(
        // column name on FinchStation serve as Primary key
        parentColumn = "name",
        // column name on FinchStationRoute serve as Foreign key
        entityColumn = "finch_station_key"
    )
    val finchStationRoutes: List<FinchStationRoute>
)
