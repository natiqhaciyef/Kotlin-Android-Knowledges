package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz

import javax.inject.Inject

data class SIMCard @Inject constructor(
    val provider: SIMCardProvider
)

class SIMCardProvider @Inject constructor() {

    fun getProviderName(): String {
        return "Bakcell"
    }
}