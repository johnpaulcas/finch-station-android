package com.finchstation.android.repository.finchstation

import androidx.lifecycle.LiveData
import com.finchstation.android.AppExecutors
import com.finchstation.android.api.ApiResponse
import com.finchstation.android.api.finchstation.FinchStationService
import com.finchstation.android.api.finchstation.response.FinchStationResponse
import com.finchstation.android.db.dao.FinchStationDao
import com.finchstation.android.db.dao.FinchStationStopDao
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.relations.FinchStationWithFinchStationTops
import com.finchstation.android.helpers.NetworkBoundResource
import com.finchstation.android.helpers.Resource
import com.finchstation.android.mapper.transferToEntity
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
        private val finchStationStopDao: FinchStationStopDao
): FinchStationRepository {

    override fun loadFinchStation(): LiveData<Resource<FinchStationWithFinchStationTops>> {
        return object : NetworkBoundResource<FinchStationWithFinchStationTops, FinchStationResponse>(appExecutors) {

            override fun saveCallResult(item: FinchStationResponse) {
                val finchStation = item.transformToEntity()
                finchStationDao.insert(finchStation)

                for (stop in item.finchStationStops!!) {
                    // save all finchstation stops of db
                    val finchStationStop = stop.transferToEntity(finchStation.name)
                    finchStationDao.insertFinchStationStop(finchStationStop)
                }
            }

            override fun shouldFetch(data: FinchStationWithFinchStationTops?): Boolean {
                Timber.d("shouldFetch called ${data == null}")
                return data == null
            }

            override fun loadFromDb(): LiveData<FinchStationWithFinchStationTops> {
                Timber.d("Load data from database")
                return finchStationDao.getFinchStationWithFinchStationStops("Finch Station")
            }

            override fun createCall(): LiveData<ApiResponse<FinchStationResponse>> {
                Timber.d("Requesting the data from api")
                return finchStationService.getFinchStation()
            }

        }.asLiveData()
    }

}