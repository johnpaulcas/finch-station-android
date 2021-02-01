package com.finchstation.android.ui.routes

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.finchstation.android.R
import com.finchstation.android.base.BaseFragment
import com.finchstation.android.databinding.FragmentRoutesBinding
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.helpers.OnItemClickListener
import com.finchstation.android.ui.components.emptyViewHolder
import com.finchstation.android.ui.components.finchStationStopViewHolder
import com.finchstation.android.ui.components.stopRouteViewHolder
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@AndroidEntryPoint
class RoutesFragment: BaseFragment(R.layout.fragment_routes) {

    private val routesViewModel: RoutesViewModel by viewModels()
    private var routesBinding: FragmentRoutesBinding? = null

    private var finchStationStop: FinchStationStop? = null
    private var finchStationRoutes = mutableListOf<FinchStationRoute>()

    override fun onBindViewResource(view: View) {
        routesBinding = FragmentRoutesBinding.bind(view)
    }

    override fun init() {
        // this is the one who will handle display view
        routesBinding?.ercStopRoutes?.withModels {

            // display the fitchstation stop
            finchStationStop?.let {
                finchStationStopViewHolder {
                    id(it.name)
                    context(requireContext())
                    finchStationStop(it)
                }
            }

            // display routes or display empty routes
            if (finchStationRoutes.size > 0) {
                finchStationRoutes.map {
                    stopRouteViewHolder {
                        id(it.name)
                        context(requireContext())
                        finchStationRoute(it)
                        onItemClickListener(object : OnItemClickListener<FinchStationRoute> {
                            override fun onItemClick(obj: FinchStationRoute) {
                                handleStopRouteOnClick(obj)
                            }

                        })
                    }
                }
            } else {
                emptyViewHolder {
                    id("empty")
                }
            }

        }

        // listen for event from viewmodel
        routesViewModel.finchStationRoutes.observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                finchStationStop = it.finchStationStop
                finchStationRoutes = it.finchStationRoutes.toMutableList()
                routesBinding?.ercStopRoutes?.requestModelBuild()
            }
        })

    }

    private fun handleStopRouteOnClick(finchStationRoute: FinchStationRoute) {
        Timber.d("finchStationRoute ${finchStationRoute}")
        val action = RoutesFragmentDirections.actionRoutesFragmentToRouteStopTimesBottomFragment(
            finchStationStop = finchStationStop,
            finchStopRoute = finchStationRoute
        )
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        // detached
        routesBinding = null
        super.onDestroy()
    }
}