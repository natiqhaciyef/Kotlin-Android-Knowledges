package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.annotations

import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.memberProperties


interface UiState {
    var isLoading: Boolean

    fun <T : UiState> makeIdle(obj: T): Idle<T>? {
        return if (isPropertiesNull(obj::class))
            Idle(setAllPropertiesNull<T, Any?>(obj, obj::class))
        else
            null
    }


    fun <T: UiState, V> setAllPropertiesNull(obj: T, clazz: KClass<out T>, onError: (Exception?) -> Unit = {}) : T{
        val properties = clazz.memberProperties.toMutableList()

        for (property in properties) {
            if (property is KMutableProperty1<*, *>) {
                (property as KMutableProperty1<T, Any?>).set(obj, null)
            } else {
                onError.invoke(IllegalArgumentException("Property ${property.name} is not mutable or does not exist"))
            }
        }
        return obj
    }

    fun <T : UiState> isPropertiesNull(clazz: KClass<T>): Boolean {
        val properties = clazz.memberProperties.toMutableList()
        val values = mutableMapOf<String, Any?>()
        for (property in properties) {
            if (property.name != "isLoading" && property.name != "isIdle") {
                values[property.name] = property.get(clazz.createInstance())
            }
        }

        return values.values.all { it == null }
    }
}

data class Idle<T: UiState>(val template: T) : UiState {
    override var isLoading: Boolean = false
}