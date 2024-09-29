package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz

import javax.inject.Inject

data class SmartPhone @Inject constructor(
    val memoryCard: MemoryCard,
    val battery: Battery,
    val simCard: SIMCard
) {

    fun getMemoryDate() : String {
        return "${memoryCard.getStorageSize()} ${memoryCard.getStorageSizeUnit()}"
    }
}
