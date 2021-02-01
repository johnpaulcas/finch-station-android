package com.finchstation.android.ui.components

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.finchstation.android.AppConstant
import com.finchstation.android.R
import com.finchstation.android.base.BaseEpoxyHolder
import com.finchstation.android.db.entities.FinchStationRouteStopTime
import com.finchstation.android.toDateFormat
import com.google.android.material.textview.MaterialTextView

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@EpoxyModelClass(layout = R.layout.item_route_stop_times)
abstract class RouteStopTimeViewHolder: EpoxyModelWithHolder<RouteStopTimeViewHolder.RouteStopTimeHolder>() {

    @EpoxyAttribute
    lateinit var context: Context

    @JvmField
    @EpoxyAttribute
    var routeStopTimes: FinchStationRouteStopTime? = null

    override fun bind(holder: RouteStopTimeHolder) {
        super.bind(holder)

        holder.mtvStopTimeName.text = routeStopTimes?.shape
        holder.mtvDepartureTime.text = "Departure Time: ${routeStopTimes?.departureTime}"
        holder.mtvDepartureTimestamp.text = "Date: ${routeStopTimes?.departureTimestamp?.toDateFormat()}"

        holder.ivTime.setColorFilter(ContextCompat.getColor(context, getRandomColor()))
    }

    private fun getRandomColor(): Int {
        return AppConstant.COLORS.shuffled()[0]
    }

    inner class RouteStopTimeHolder: BaseEpoxyHolder() {
        val ivTime by bind<AppCompatImageView>(R.id.ivTime)
        val mtvDepartureTime by bind<MaterialTextView>(R.id.mtvDepartureTime)
        val mtvDepartureTimestamp by bind<MaterialTextView>(R.id.mtvDepartureTimestamp)
        val mtvStopTimeName by bind<MaterialTextView>(R.id.mtvStopTimeName)
    }

}