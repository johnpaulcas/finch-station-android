package com.fitchstation.android.ui.fitchstation

import android.view.View
import com.fitchstation.android.R
import com.fitchstation.android.base.BaseFragment
import com.fitchstation.android.databinding.FragmentFitchStatonBinding

/**
 * Created by johnpaulcas on 29/01/2021.
 */
class FitchStationFragment: BaseFragment(R.layout.fragment_fitch_staton) {

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