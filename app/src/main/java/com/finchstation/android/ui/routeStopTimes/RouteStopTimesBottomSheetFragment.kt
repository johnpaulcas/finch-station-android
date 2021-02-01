package com.finchstation.android.ui.routeStopTimes

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.doOnLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.finchstation.android.R
import com.finchstation.android.databinding.FragmentRouteStopTimesBinding
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.ui.components.finchStationStopViewHolder
import com.finchstation.android.ui.components.stopRouteViewHolder
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@AndroidEntryPoint
class RouteStopTimesBottomFragment: BottomSheetDialogFragment() {

    private val viewModel: RouteStopTimesBottomViewModel by viewModels()
    private var routeStopTimeBinding: FragmentRouteStopTimesBinding? = null

    private var finchStationStop: FinchStationStop? = null
    private var finchStationRoute: FinchStationRoute? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        routeStopTimeBinding = FragmentRouteStopTimesBinding.inflate(inflater, container, false)
        return routeStopTimeBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        routeStopTimeBinding?.ercRouteStopTimes?.withModels {
            Timber.d("refreshing here...")

            // load finch station stop
            finchStationStop?.let {
                Timber.d("data refresh 1")
                finchStationStopViewHolder {
                    id(it.name)
                    context(requireContext())
                    finchStationStop(it)
                }
            }

            // load finch statio route
            finchStationRoute?.let {
                Timber.d("data refresh 2")
                stopRouteViewHolder {
                    id(it.name)
                    context(requireContext())
                    finchStationRoute(it)
                }
            }
        }

        viewModel.finchStationRoute.observe(viewLifecycleOwner, Observer { fsr ->
            fsr?.let {
                finchStationRoute = it
                Timber.d("observe $it")
                routeStopTimeBinding?.ercRouteStopTimes?.requestModelBuild()
            }
        })

        viewModel.finchStationStop.observe(viewLifecycleOwner, Observer { fst ->
            fst?.let {
                finchStationStop = it
                Timber.d("observe $it")
                routeStopTimeBinding?.ercRouteStopTimes?.requestModelBuild()
            }
        })

    }

    override fun onDestroyView() {
        routeStopTimeBinding = null
        super.onDestroyView()
    }

}