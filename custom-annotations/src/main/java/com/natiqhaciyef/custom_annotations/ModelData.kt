package com.natiqhaciyef.custom_annotations

data class ModelData(
   var packageName: String,
   var modelName: String,
   var layoutId: Int,
   var viewHolderBindingData: List<ViewHolderBindingData>
)
