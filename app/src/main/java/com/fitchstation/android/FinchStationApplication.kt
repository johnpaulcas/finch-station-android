package com.fitchstation.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 */
@HiltAndroidApp
class FinchStationApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Setup timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}