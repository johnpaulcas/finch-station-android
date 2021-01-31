package com.finchstation.android.ui.finchstation

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.finchstation.android.R
import com.finchstation.android.base.BaseFragment
import com.finchstation.android.databinding.FragmentFinchStatonBinding
import com.finchstation.android.helpers.Resource
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by johnpaulcas on 29/01/2021.
 */
@AndroidEntryPoint
class FinchStationFragment: BaseFragment(R.layout.fragment_finch_staton) {

    private val finchStationViewModel: FinchStationViewModel by viewModels()
    private var fitchStationBinding: FragmentFinchStatonBinding? = null

    override fun onBindViewResource(view: View) {
        fitchStationBinding = FragmentFinchStatonBinding.bind(view)
    }

    override fun init() {
        finchStationViewModel.loadData().observe(viewLifecycleOwner, Observer { resource ->

        })
    }

    override fun onDestroyView() {
        fitchStationBinding = null
        super.onDestroyView()
    }
}