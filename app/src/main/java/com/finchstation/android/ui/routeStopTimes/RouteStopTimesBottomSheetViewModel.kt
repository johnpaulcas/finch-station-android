package com.finchstation.android.ui.routeStopTimes

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.finchstation.android.db.dao.FinchStationRouteDao
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.db.relations.FinchStationRouteWithFinchStationStopTimes
import com.finchstation.android.ui.routes.RoutesViewModel
import dagger.hilt.android.scopes.FragmentScoped
import timber.log.Timber

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@FragmentScoped
class RouteStopTimesBottomSheetViewModel @ViewModelInject constructor(
    @Assisted private val state: SavedStateHandle,
    private val routeStopTimesDao: FinchStationRouteDao
): ViewModel() {

    private val _finchStationStop = MutableLiveData<FinchStationStop>()
    private val _finchStationRoute = MutableLiveData<FinchStationRoute>()

    val finchStationStop: LiveData<FinchStationStop>
        get() = _finchStationStop

    val finchStationRoute: LiveData<FinchStationRoute>
        get() = _finchStationRoute

    val routeWithStopTimes: LiveData<FinchStationRouteWithFinchStationStopTimes>
        get() = routeStopTimesDao.getFinchStationRouteWithFinchStationStopTimes(
            state.get<FinchStationRoute>(FINCH_STOP_ROUTE)!!.name
        )

    companion object {
        const val FINCH_STATION_STOP = "finchStationStop"
        const val FINCH_STOP_ROUTE = "finchStopRoute"
    }

    init {
        val finchStationStop = state.get<FinchStationStop>(FINCH_STATION_STOP)
        val finchStationRoute = state.get<FinchStationRoute>(FINCH_STOP_ROUTE)

        _finchStationStop.postValue(finchStationStop)
        _finchStationRoute.postValue(finchStationRoute)
    }

}