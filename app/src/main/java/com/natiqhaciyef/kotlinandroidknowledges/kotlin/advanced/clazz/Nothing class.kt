package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.clazz

fun throwException(msg: String): Nothing {
    throw IllegalStateException(msg)
}


fun checkString(str: String?): Int {
    return when {
        str.isNullOrBlank() -> throwException("Empty string")
        else -> str.length
    }
}

fun checkString2(str: String?): Int {
    val size = str?.length ?: throwException("Null string")

    return size
}
