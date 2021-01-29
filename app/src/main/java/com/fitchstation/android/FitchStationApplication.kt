package com.fitchstation.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by johnpaulcas on 29/01/2021.
 */
@HiltAndroidApp
class FitchStationApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Setup timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}