package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas


/** What is closure?
 * Closure is an action in Kotlin Lambda Expressions. While using lambda or high order functions
 * in Java it isn't possible to modify outer variable in lambda expression scopes. So you cannot set value
 * to outer variable from lambda scope. But in Kotlin it is possible to do it. You can set value to outer object
 * from the lambda scope. Even you call lambda in another function (as a high order function) it still can change
 * the value of outer variable. It names as Closure.
 * */

fun main() {
    var result = 0
    println(result)

    val lambda: (Int, Int) -> Unit = { x, y -> result = x + y }
    operateAction(14, 22, lambda)
}

fun operateAction(a: Int, b: Int, func: (Int, Int) -> Unit) {
    val operationResult = func(a, b)

    println(operationResult)
}