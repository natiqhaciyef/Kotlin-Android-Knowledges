package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced

fun main() {
    getParam1(listOf("User name", "User age"))
    getParam1(listOf(0, 1, 2, 3))

    val list = mutableListOf("User name", "User age")
}

fun unReach(someNullable: String?) {
    val nonNull: String = someNullable ?: throw NotImplementedError()
    nonNull.last()

}

inline fun <reified T> getParam1(list: List<T>) {
    if (list is List<*>) {
        val listNumber = list as List<Int>
        println(listNumber)
    }
}
