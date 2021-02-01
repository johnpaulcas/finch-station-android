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
import com.finchstation.android.db.entities.FinchStationStop
import com.finchstation.android.helpers.OnItemClickListener
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@EpoxyModelClass(layout = R.layout.item_finch_station_stop)
abstract class FinchStationStopViewHolder: EpoxyModelWithHolder<FinchStationStopViewHolder.FinchStationStopHolder>() {

    @EpoxyAttribute
    lateinit var context: Context

    @JvmField
    @EpoxyAttribute
    var finchStationStop: FinchStationStop? = null

    @JvmField
    @EpoxyAttribute
    var onItemClick: OnItemClickListener<FinchStationStop>? = null

    override fun bind(holder: FinchStationStopHolder) {
        super.bind(holder)
        finchStationStop?.let {
            holder.mtvName.text = it.name
            holder.mtvAgency.text = it.agency

            holder.ivTrain.setColorFilter(ContextCompat.getColor(context, getRandomColor()))

            if (onItemClick != null) {
                holder.mcvFinchStationStop.setOnClickListener {
                    onItemClick?.onItemClick(finchStationStop!!)
                }
            }
        }
    }

    private fun getRandomColor(): Int {
        return AppConstant.COLORS.shuffled()[0]
    }

    inner class FinchStationStopHolder: BaseEpoxyHolder() {
        val mcvFinchStationStop by bind<MaterialCardView>(R.id.mcvFinchStationStop)
        val ivTrain by bind<AppCompatImageView>(R.id.ivTrain)
        val mtvName by bind<MaterialTextView>(R.id.mtvName)
        val mtvAgency by bind<MaterialTextView>(R.id.mtvAgency)
    }

}