package com.finchstation.android.ui.components

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.lottie.LottieAnimationView
import com.finchstation.android.R
import com.finchstation.android.base.BaseEpoxyHolder

/**
 * @author johnpaulcas
 * @since 01/02/2021
 */
@EpoxyModelClass(layout = R.layout.item_loading)
abstract class LoadingViewHolder: EpoxyModelWithHolder<LoadingViewHolder.LoadingHolder>() {

    override fun bind(holder: LoadingHolder) {
        super.bind(holder)
    }

    inner class LoadingHolder: BaseEpoxyHolder() {
        val lavLoading by bind<LottieAnimationView>(R.id.lavLoading)
    }

}