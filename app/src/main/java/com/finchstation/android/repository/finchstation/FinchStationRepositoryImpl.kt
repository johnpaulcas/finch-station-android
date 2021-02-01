package com.finchstation.android.repository.finchstation

import androidx.lifecycle.LiveData
import com.finchstation.android.AppExecutors
import com.finchstation.android.api.ApiResponse
import com.finchstation.android.api.finchstation.FinchStationService
import com.finchstation.android.api.finchstation.response.FinchStationResponse
import com.finchstation.android.api.finchstation.response.models.Route
import com.finchstation.android.api.finchstation.response.models.RouteStopTime
import com.finchstation.android.db.dao.FinchStationDao
import com.finchstation.android.db.dao.FinchStationRouteDao
import com.finchstation.android.db.dao.FinchStationRouteStopTimeDao
import com.finchstation.android.db.dao.FinchStationStopDao
import com.finchstation.android.db.relations.FinchStationWithFinchStationTops
import com.finchstation.android.helpers.NetworkBoundResource
import com.finchstation.android.helpers.Resource
import com.finchstation.android.mapper.transformToEntity
import timber.log.Timber

/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 * Repository to handle the api request and save data to database
 * return the result to ViewModel
 *
 * @see FinchStationRepository
 */
class FinchStationRepositoryImpl(
        private val appExecutors: AppExecutors,
        private val finchStationService: FinchStationService,
        private val finchStationDao: FinchStationDao,
        private val finchStationStopDao: FinchStationStopDao,
        private val finchStationRouteDao: FinchStationRouteDao,
        private val finchStationRouteStopTimeDao: FinchStationRouteStopTimeDao
): FinchStationRepository {


    override fun loadFinchStation(): LiveData<Resource<FinchStationWithFinchStationTops>> {
        return object : NetworkBoundResource<FinchStationWithFinchStationTops, FinchStationResponse>(appExecutors) {

            override fun saveCallResult(item: FinchStationResponse) {
                val finchStation = item.transformToEntity()
                finchStationDao.insert(finchStation)

                // delete all routes stop times before looping
                finchStationRouteStopTimeDao.deleteAll()

                // save all data
                item.finchStationStops?.let { finchStationStops ->
                    saveFinchStationStops(finchStation.name, finchStationStops)
                }
            }

            override fun shouldFetch(data: FinchStationWithFinchStationTops?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<FinchStationWithFinchStationTops> {
                return finchStationDao.getFinchStationWithFinchStationStops("Finch Station")
            }

            override fun createCall(): LiveData<ApiResponse<FinchStationResponse>> {
                return finchStationService.getFinchStation()
            }

        }.asLiveData()
    }

    /**
     * Save finch station stop to finch_station_stop
     *
     * @param pk
     * The finch_station_stop Foreign Key
     * @param
     * List of FinchStationStop api/finchstation/model
     */
    private fun saveFinchStationStops(
            pk: String,
            finchStationStops: List<com.finchstation.android.api.finchstation.response.models.FinchStationStop>
    ) {
        for (finchStationStop in finchStationStops) {
            val fsStop = finchStationStop.transformToEntity(pk)
            finchStationDao.insertFinchStationStop(fsStop)
            saveFinchStationRoute(finchStationStop.name, finchStationStop.routes)
        }
    }

    /**
     * Save route to finch_station_route table
     *
     * @param pk
     * The finch_station_route foreign key
     * @param finchStationRoutes
     * The list of routes
     */
    private fun saveFinchStationRoute(pk: String, finchStationRoutes: List<Route>?) {
        // make sure that finchStationRoutes is not null
        finchStationRoutes?.let { finchStationRoutes ->
            // make sure not to execute the loop when list is empty
            if (finchStationRoutes.isNotEmpty()) {

                for (stopRoute in finchStationRoutes) {
                    val sr = stopRoute.transformToEntity(pk)
                    finchStationStopDao.insertFinchStationRoute(sr)
                    saveFinchStationRouteStopTime(stopRoute.name, stopRoute.stopTimes)
                }
            }
        }
    }

    /**
     * Save RouteStopTime to finch_station_routes_stop_time
     *
     * @param pk
     * The finch_station_routes_stop_time foreign key
     * @param
     * List of RouteStopTimes
     */
    private fun saveFinchStationRouteStopTime(
            pk: String,
            routeStopTimes: List<RouteStopTime>?
    ) {
        routeStopTimes?.let { routeStopTimes ->
            // make sure that route stop times is not null
            if (routeStopTimes.isNotEmpty()) {
                // don't execute the loop if routeStopTimes is empty
                for (routeStopTime in routeStopTimes) {
                    Timber.d("Called ...")
                    val rst = routeStopTime.transformToEntity(pk)
                    finchStationRouteDao.insertRouteTimeStop(rst)
                }
            }

        }
    }

}