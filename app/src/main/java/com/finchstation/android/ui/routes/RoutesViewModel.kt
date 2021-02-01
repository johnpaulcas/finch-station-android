package com.finchstation.android.ui.routes

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.db.relations.FinchStationStopWithFinchStationRoutes
import com.finchstation.android.repository.routes.RoutesRepository
import dagger.hilt.android.scopes.FragmentScoped

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@FragmentScoped
class RoutesViewModel @ViewModelInject constructor(
    @Assisted private val state: SavedStateHandle,
    private val routesRepository: RoutesRepository
): ViewModel() {

    companion object {
        const val ARG_KEY = "finchStationStop"
    }

    val finchStationRoutes: LiveData<FinchStationStopWithFinchStationRoutes>
        get() = routesRepository.getStopRoutes(state.get<FinchStationStop>(ARG_KEY)!!.name)

}