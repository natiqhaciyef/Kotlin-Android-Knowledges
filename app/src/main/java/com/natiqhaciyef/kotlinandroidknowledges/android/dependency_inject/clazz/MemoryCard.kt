package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz

import javax.inject.Inject

class MemoryCard @Inject constructor() {

    fun getStorageSize(): Int {
        return 128
    }

    fun getStorageSizeUnit(): String {
        return "GB"
    }
}
