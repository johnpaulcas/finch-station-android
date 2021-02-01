package com.finchstation.android.ui.finchstation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.relations.FinchStationWithFinchStationTops
import com.finchstation.android.helpers.Resource
import com.finchstation.android.repository.finchstation.FinchStationRepository
import dagger.hilt.android.scopes.FragmentScoped

/**
 * @author johnpaulcas
 * @since 29/01/2021
 */
@FragmentScoped
class FinchStationViewModel @ViewModelInject constructor(
    private val finchStationRepository: FinchStationRepository
): ViewModel() {

    fun loadData(): LiveData<Resource<FinchStationWithFinchStationTops>> {
        return finchStationRepository.loadFinchStation()
    }

}