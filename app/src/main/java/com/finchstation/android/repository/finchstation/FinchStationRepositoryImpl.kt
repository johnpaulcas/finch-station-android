package com.finchstation.android.repository.finchstation

import androidx.lifecycle.LiveData
import com.finchstation.android.AppExecutors
import com.finchstation.android.api.ApiResponse
import com.finchstation.android.api.finchstation.FinchStationService
import com.finchstation.android.api.finchstation.response.FinchStationResponse
import com.finchstation.android.db.dao.FinchStationDao
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.helpers.NetworkBoundResource
import com.finchstation.android.helpers.Resource
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
        private val finchStationDao: FinchStationDao
): FinchStationRepository {

    override fun loadFinchStation(): LiveData<Resource<FinchStation>> {
        return object : NetworkBoundResource<FinchStation, FinchStationResponse>(appExecutors) {

            override fun saveCallResult(item: FinchStationResponse) {
                Timber.d("Item retrieved $item")
            }

            override fun shouldFetch(data: FinchStation?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<FinchStation> {
                Timber.d("Load data from database")
                return finchStationDao.getAll("Finch Station")
            }

            override fun createCall(): LiveData<ApiResponse<FinchStationResponse>> {
                Timber.d("Requesting the data from api")
                return finchStationService.getFinchStation()
            }

        }.asLiveData()
    }

}