package com.finchstation.android.ui.components

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.lottie.LottieAnimationView
import com.finchstation.android.AppConstant
import com.finchstation.android.R
import com.finchstation.android.base.BaseEpoxyHolder
import com.finchstation.android.db.entities.FinchStationRoute
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.helpers.OnItemClickListener
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@EpoxyModelClass(layout = R.layout.item_stop_route)
abstract class StopRouteViewHolder: EpoxyModelWithHolder<StopRouteViewHolder.StopRouteHolder>() {

    @EpoxyAttribute
    lateinit var context: Context

    @JvmField
    @EpoxyAttribute
    var finchStationRoute: FinchStationRoute? = null

    @JvmField
    @EpoxyAttribute
    var onItemClickListener: OnItemClickListener<FinchStationRoute>? = null

    override fun bind(holder: StopRouteHolder) {
        super.bind(holder)

        holder.mtvRouteName.text = finchStationRoute?.name
        holder.ivDirection.setColorFilter(ContextCompat.getColor(context, getRandomColor()))

        holder.mcvFinchStationRoute.setOnClickListener {
            onItemClickListener?.onItemClick(finchStationRoute!!)
        }
    }

    private fun getRandomColor(): Int {
        return AppConstant.COLORS.shuffled()[0]
    }

    inner class StopRouteHolder: BaseEpoxyHolder() {
        val ivDirection by bind<AppCompatImageView>(R.id.ivDirection)
        val mcvFinchStationRoute by bind<MaterialCardView>(R.id.mcvFinchStationRoute)
        val mtvRouteName by bind<MaterialTextView>(R.id.mtvRouteName)
    }

}