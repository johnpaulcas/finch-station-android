package com.finchstation.android.repository.finchstation

import androidx.lifecycle.LiveData
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.db.relations.FinchStationWithFinchStationTops
import com.finchstation.android.helpers.Resource

/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 */
interface FinchStationRepository {

    /**
     * This will handle the fetching of data from api
     * to the caching to local databae which is room
     */
    fun loadFinchStation(): LiveData<Resource<FinchStationWithFinchStationTops>>

}