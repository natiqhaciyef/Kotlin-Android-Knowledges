package com.natiqhaciyef.kotlinandroidknowledges.android.view.epoxy

import com.airbnb.epoxy.EpoxyController
import com.bumptech.glide.Glide
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ModelHomeBodyBinding
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ModelHomeFooterBinding
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ModelHomeHeaderBinding
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ModelHomeLoadingBinding

class HomeEpoxyController : EpoxyController() {

    var isLoading: Boolean = true
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }

    var model: HomeEpoxyModel? = null
        set(value) {
            field = value
            if (field != null) {
                isLoading = false
                requestModelBuild()
            }
        }

    override fun buildModels() {
        if (isLoading) {
            // shows loading state
            LoadingEpoxyModel().id("loading").addTo(this)
            return
        }

        if (model == null) {
            // if null state
            return
        }

        HomeHeaderEpoxyModel(
            title = model!!.title,
            batteryLevel = model!!.batteryLevel
        ).id("home_header").addTo(this)

        HomeBodyEpoxyModel(
            image = model!!.image,
        ).id("home_body").addTo(this)

        HomeFooterEpoxyModel(
            info = model!!.info,
            details = model!!.details
        ).id("home_footer").addTo(this)

        // add header model
        // add image model
        // add footer model

    }

    data class HomeHeaderEpoxyModel(
        var title: String,
        var batteryLevel: Int
    ) : ViewBindingKotlinModel<ModelHomeHeaderBinding>(R.layout.model_home_header) {

        override fun ModelHomeHeaderBinding.bind() {
            val iconId = when (batteryLevel) {
                0 -> R.drawable.battery_0_icon
                1 -> R.drawable.battery_1_icon
                2, 3 -> R.drawable.battery_2_icon
                4 -> R.drawable.battery_3_icon
                5, 6 -> R.drawable.battery_4_icon
                7, 8 -> R.drawable.battery_5_icon
                9 -> R.drawable.battery_6_icon
                10 -> R.drawable.battery_full_icon
                else -> R.drawable.battery_alert_icon
            }
            headerTitle.text = title
            headerIcon.setImageResource(iconId)
        }
    }

    data class HomeBodyEpoxyModel(
        var image: String
    ) : ViewBindingKotlinModel<ModelHomeBodyBinding>(R.layout.model_home_body) {

        override fun ModelHomeBodyBinding.bind() {
            Glide.with(this.root).load(image).into(bodyImage)
        }
    }

    data class HomeFooterEpoxyModel(
        var info: String,
        var details: String
    ) : ViewBindingKotlinModel<ModelHomeFooterBinding>(R.layout.model_home_footer) {

        override fun ModelHomeFooterBinding.bind() {
            footerTitle.text = info
            footerDescription.text = details
        }
    }

    class LoadingEpoxyModel() :
        ViewBindingKotlinModel<ModelHomeLoadingBinding>(R.layout.model_home_loading) {
        override fun ModelHomeLoadingBinding.bind() {

        }
    }
}