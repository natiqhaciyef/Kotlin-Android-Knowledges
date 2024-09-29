package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz

import javax.inject.Inject

data class Phone @Inject constructor(
    val battery: Battery,
    val phoneOwner: Owner,
    val brand: PhoneBrand
)
