package com.finchstation.android.ui.routeStopTimes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.finchstation.android.databinding.FragmentRouteStopTimesBinding
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationRouteStopTime
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.ui.components.finchStationStopViewHolder
import com.finchstation.android.ui.components.routeStopTimeViewHolder
import com.finchstation.android.ui.components.stopRouteViewHolder
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@AndroidEntryPoint
class RouteStopTimesBottomSheetFragment: BottomSheetDialogFragment() {

    private val sheetViewModel: RouteStopTimesBottomSheetViewModel by viewModels()
    private var routeStopTimeBinding: FragmentRouteStopTimesBinding? = null

    private var finchStationStop: FinchStationStop? = null
    private var finchStationRoute: FinchStationRoute? = null

    private var routeStopTimes = mutableListOf<FinchStationRouteStopTime>()

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

            // load stop times
            routeStopTimes.map {
                routeStopTimeViewHolder {
                    id(it.id)
                    context(requireContext())
                    routeStopTimes(it)
                }
            }
        }

        routeStopTimeBinding?.ivClose?.setOnClickListener {
            dismiss()
        }

        observer()
    }

    private fun observer() {
        sheetViewModel.finchStationRoute.observe(viewLifecycleOwner, Observer { fsr ->
            fsr?.let {
                finchStationRoute = it
                Timber.d("observe $it")
                routeStopTimeBinding?.ercRouteStopTimes?.requestModelBuild()
            }
        })

        sheetViewModel.finchStationStop.observe(viewLifecycleOwner, Observer { fst ->
            fst?.let {
                finchStationStop = it
                Timber.d("observe $it")
                routeStopTimeBinding?.ercRouteStopTimes?.requestModelBuild()
            }
        })

        sheetViewModel.routeWithStopTimes.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                routeStopTimes = it.finchStationStopTimes.toMutableList()
                routeStopTimeBinding?.ercRouteStopTimes?.requestModelBuild()
            }
        })
    }

    override fun onDestroyView() {
        routeStopTimeBinding = null
        super.onDestroyView()
    }

}