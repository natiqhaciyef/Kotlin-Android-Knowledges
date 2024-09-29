package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz

import javax.inject.Inject

class PixelPhone @Inject constructor( ) : PhoneBrand {
    override val title: String = "Google Pixel"
    override fun brandSupportCenterLocation(): String {
        return "San Francisco, USA"
    }
}