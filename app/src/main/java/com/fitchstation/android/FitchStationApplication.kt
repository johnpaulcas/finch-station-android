package com.fitchstation.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by johnpaulcas on 29/01/2021.
 */
@HiltAndroidApp
class FitchStationApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}