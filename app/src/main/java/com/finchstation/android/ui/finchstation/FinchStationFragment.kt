package com.finchstation.android.ui.finchstation

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.finchstation.android.R
import com.finchstation.android.base.BaseFragment
import com.finchstation.android.databinding.FragmentFinchStatonBinding
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.helpers.OnItemClickListener
import com.finchstation.android.helpers.Status
import com.finchstation.android.ui.components.errorViewHolder
import com.finchstation.android.ui.components.finchStationStopViewHolder
import com.finchstation.android.ui.components.loadingViewHolder
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by johnpaulcas on 29/01/2021.
 */
@AndroidEntryPoint
class FinchStationFragment: BaseFragment(R.layout.fragment_finch_staton) {

    private val finchStationViewModel: FinchStationViewModel by viewModels()
    private var finchStationBinding: FragmentFinchStatonBinding? = null

    private var finchStationStops = mutableListOf<FinchStationStop>()
    private var isLoading = true
    private var hasError = false;

    override fun onBindViewResource(view: View) {
        finchStationBinding = FragmentFinchStatonBinding.bind(view)
    }

    override fun init() {
        // show list of finchStation stops
        finchStationBinding?.ercFinchStationStop?.withModels {

            if (hasError) {
                errorViewHolder {
                    id("error")
                    onItemClickListener(object: OnItemClickListener<Void> {
                        override fun onItemClick(obj: Void) {
                            handleRefresh()
                        }

                    })
                }
            }else if (!isLoading) {
                finchStationStops.map { finchStationStop ->
                    finchStationStopViewHolder {
                        context(requireContext())
                        id(finchStationStop.name)
                        finchStationStop(finchStationStop)
                        onItemClick(object : OnItemClickListener<FinchStationStop> {
                            override fun onItemClick(obj: FinchStationStop) {
                                // handle item click
                                handleFinchStationStopClick(obj)
                            }

                        })
                    }
                }
            } else {
                loadingViewHolder {
                    id("Loading")
                }
            }
        }

        // observe changes from view model
        finchStationViewModel.loadData().observe(viewLifecycleOwner, Observer { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    finchStationStops = resource.data?.finchStationStops!!.toMutableList()
                    hideLoading()
                }
                Status.LOADING -> {
                    showLoading()
                }
                Status.ERROR -> {
                    showError()
                }
            }
        })
    }

    private fun handleFinchStationStopClick(finchStationStop: FinchStationStop) {
        // goto stop routes
        val action = FinchStationFragmentDirections.actionFinchStationFragmentToRoutesFragment(finchStationStop)
        findNavController().navigate(action)
    }

    private fun handleRefresh() {
        finchStationViewModel.loadData()
    }

    override fun onDestroyView() {
        finchStationBinding = null
        super.onDestroyView()
    }

    private fun showLoading() {
        isLoading = true
        hasError = false
        finchStationBinding?.ercFinchStationStop?.requestModelBuild()
    }

    private fun hideLoading() {
        isLoading = false
        hasError = false
        finchStationBinding?.ercFinchStationStop?.requestModelBuild()
    }

    private fun showError() {
        isLoading = false
        hasError = true
        finchStationBinding?.ercFinchStationStop?.requestModelBuild()
    }
}