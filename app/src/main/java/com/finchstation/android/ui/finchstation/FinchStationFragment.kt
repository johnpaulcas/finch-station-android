package com.finchstation.android.ui.finchstation

import android.view.View
import com.finchstation.android.R
import com.finchstation.android.base.BaseFragment
import com.finchstation.android.databinding.FragmentFitchStatonBinding

/**
 * Created by johnpaulcas on 29/01/2021.
 */
class FinchStationFragment: BaseFragment(R.layout.fragment_fitch_staton) {

    private var fitchStationBinding: FragmentFitchStatonBinding? = null

    override fun onBindViewResource(view: View) {
        fitchStationBinding = FragmentFitchStatonBinding.bind(view)
    }

    override fun init() {
    }

    override fun onDestroyView() {
        fitchStationBinding = null
        super.onDestroyView()
    }
}