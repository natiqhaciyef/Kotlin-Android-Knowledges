package com.natiqhaciyef.kotlinandroidknowledges.android.annotations_advanced

import com.natiqhaciyef.custom_annotations.kapt.AdapterModel
import com.natiqhaciyef.custom_annotations.kapt.ViewHolderBinding
import com.natiqhaciyef.kotlinandroidknowledges.R

@AdapterModel(R.layout.empty_layout)
data class Person(
    @ViewHolderBinding(R.id.titleText)
    val name: String,
    val address: String
)