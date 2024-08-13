package com.natiqhaciyef.custom_annotations.kapt

data class ModelData(
   var packageName: String,
   var modelName: String,
   var layoutId: Int,
   var viewHolderBindingData: List<ViewHolderBindingData>
)
