package com.fitchstation.android.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 * @author johnpaulcas
 * @since 29/01/2021
 *
 */
abstract class BaseFragment(layoutResourceId: Int): Fragment(layoutResourceId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBindViewResource(view)

        init()

    }

    /**
     * Bind view resource
     */
    abstract fun onBindViewResource(view: View)

    /**
     * Function to handle the initialization
     * of observer/view/components
     */
    abstract fun init()

}