package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.generics

fun <T1, T2, R> ((T1) -> T2).andThen(func: (T2) -> R): (T1) -> R =
    { t1 -> func.invoke(this.invoke(t1)) }

fun doubleStrings(str: String): String = "$str $str"

fun lengthOfString(str: String): Int = str.length


fun main() {
    val operation = ::doubleStrings.andThen(::lengthOfString)
    println(operation.invoke("A"))
}