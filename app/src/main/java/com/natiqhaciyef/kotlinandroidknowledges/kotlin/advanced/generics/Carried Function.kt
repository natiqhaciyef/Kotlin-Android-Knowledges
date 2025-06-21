package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.generics

fun collector(num1: Int, num2: Int) = num1 + num2


// this called partial function
fun <T1, T2, R> ((T1, T2) -> R).carried(): (T1) -> (T2) -> R =
    { t1 -> { t2 -> this.invoke(t1, t2) } }


fun main() {

    val currentValue: (Int) -> (Double) -> String = { num1 -> { num2 -> "$num1 ------ $num2" } }

    currentValue.invoke(1111).invoke(10.1)
}