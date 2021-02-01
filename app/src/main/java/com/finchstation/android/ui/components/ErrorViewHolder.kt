package com.finchstation.android.ui.components

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.finchstation.android.R
import com.finchstation.android.base.BaseEpoxyHolder
import com.finchstation.android.helpers.OnItemClickListener
import com.google.android.material.button.MaterialButton

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@EpoxyModelClass(layout = R.layout.item_error)
abstract class ErrorViewHolder: EpoxyModelWithHolder<ErrorViewHolder.ErrorHolder>() {

    @JvmField
    @EpoxyAttribute
    var onItemClickListener: OnItemClickListener<Void?>? = null

    override fun bind(holder: ErrorHolder) {
        super.bind(holder)
        holder.mbRefresh.setOnClickListener {
            onItemClickListener?.onItemClick(null)
        }
    }

    inner class ErrorHolder: BaseEpoxyHolder() {
        val mbRefresh by bind<MaterialButton>(R.id.mbRefresh)
    }
}