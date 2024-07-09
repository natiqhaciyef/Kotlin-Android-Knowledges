package com.natiqhaciyef.kotlinandroidknowledges.android.annotations_advanced

import com.natiqhaciyef.custom_annotations.AdapterModel
import com.natiqhaciyef.custom_annotations.ViewHolderBinding
import com.natiqhaciyef.kotlinandroidknowledges.R

@AdapterModel(R.layout.empty_layout)
data class Person(
    @ViewHolderBinding(R.id.titleText)
    val name: String,
    val address: String
)