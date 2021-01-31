package com.finchstation.android.mapper

import com.finchstation.android.api.finchstation.response.FinchStationResponse
import com.finchstation.android.api.finchstation.response.models.FinchStationStop
import com.finchstation.android.api.finchstation.response.models.Route
import com.finchstation.android.api.finchstation.response.models.RouteStopTime
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime

/**
 * @author johnpaulcas
 * @since 31/01/2021
 *
 * <p>
 *     This class serve as FinchStation `Extension` class mapper from
 *     api/finchstation/response to db/entities
 * </p>
 */

fun FinchStationResponse.transformToEntity(): FinchStation {
    return FinchStation(
            name,
            time,
            uri
    )
}

fun FinchStationStop.transferToEntity(
        foreignKey: String
): com.finchstation.android.db.entities.FinchStationStop {
    return com.finchstation.android.db.entities.FinchStationStop(
            finchStationKey = foreignKey,
            this.name,
            this.uri,
            this.agency
    )
}

fun Route.transferToEntity(foreignKey: String): FinchStationRoute {
    return FinchStationRoute(
            finchStationKey = foreignKey,
            this.name,
            this.uri
    )
}

fun RouteStopTime.transferToEnity(foreignKey: String): FinchStationRouteStopTime {
    return FinchStationRouteStopTime(
            finchStationRouteKey = foreignKey,
            this.serviceId,
            this.shape,
            this.departureTime,
            this.departureTimestamp
    )
}
