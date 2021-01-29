package com.finchstation.android.ui.finchstation

import android.view.View
import com.finchstation.android.R
import com.finchstation.android.base.BaseFragment
import com.finchstation.android.databinding.FragmentFinchStatonBinding

/**
 * Created by johnpaulcas on 29/01/2021.
 */
class FinchStationFragment: BaseFragment(R.layout.fragment_finch_staton) {

    private var fitchStationBinding: FragmentFinchStatonBinding? = null

    override fun onBindViewResource(view: View) {
        fitchStationBinding = FragmentFinchStatonBinding.bind(view)
    }

    override fun init() {
    }

    override fun onDestroyView() {
        fitchStationBinding = null
        super.onDestroyView()
    }
}