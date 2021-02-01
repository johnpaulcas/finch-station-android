package com.finchstation.android.ui.components

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.finchstation.android.R
import com.finchstation.android.base.BaseEpoxyHolder

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@EpoxyModelClass(layout = R.layout.item_empty)
abstract class EmptyViewHolder: EpoxyModelWithHolder<EmptyViewHolder.EmptyHolder>() {

    override fun bind(holder: EmptyHolder) {
        super.bind(holder)
    }

    inner class EmptyHolder: BaseEpoxyHolder() {

    }
}