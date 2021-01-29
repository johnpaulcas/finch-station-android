package com.finchstation.android.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime

/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 * <p>
 *      Relation between FinchStationRoute and FinchStationRouteStopTime
 *      1 to N
 *
 *      Join finch_station_route and finch_station_route_stop_time
 * </>
 *
 * @see FinchStationRoute
 * @see FinchStationRouteStopTime
 */
data class FinchStationRouteWithFinchStationRouteStopTimes (
    @Embedded val finchStationRoute: FinchStationRoute,
    @Relation(
        // FinchStationRoute primary key
        parentColumn = "name",
        // FinchStationRouteStopTime foreign key
        entityColumn = "finch_station_route_key"
    )
    val finchStationRouteStopTimes: List<FinchStationRouteStopTime>
)
