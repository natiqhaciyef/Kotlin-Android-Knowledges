package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced

fun main() {
    getParam1(listOf("User name","User age"))
    getParam1(listOf(0,1,2,3))
}

fun unReach(someNullable: String?){
    val nonNull: String = someNullable ?: throw NotImplementedError()
    nonNull.last()

    val thing: Nothing = TODO("String")
}

fun <T> getParam1(list: List<T>){
    if (list is List<*>){
        val listNumber = list as List<Int>
        println(listNumber)
    }
}