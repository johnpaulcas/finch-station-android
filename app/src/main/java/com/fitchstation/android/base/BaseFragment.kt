package com.fitchstation.android.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 * Created by johnpaulcas on 29/01/2021.
 */
abstract class BaseFragment(layoutResourceId: Int): Fragment(layoutResourceId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBindViewResource(view)
    }

    abstract fun onBindViewResource(view: View)

    abstract fun init()

}