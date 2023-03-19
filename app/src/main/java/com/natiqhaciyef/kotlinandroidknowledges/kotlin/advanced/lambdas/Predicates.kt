package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas

fun main() {
    val list = listOf<Int>(1,111,2,17,22,20,3,87,12,4,6,5,99,37,9,11)

    // all check
    println(list.all { it < 100 })      // false
    list.all { it < 10 }                // false

    // any check
    println(list.any{ it > 10})         // true

    // total count
    println(list.count { it > 12 })     // count of numbers which > 12

    // find first & last number
    println(list.find { it > 5 })       // 111
    println(list.findLast { it > 5 })   // 11


    // create own predicate
    val myPredicate = { num: Int -> num > 10}
    list.all(myPredicate)
}