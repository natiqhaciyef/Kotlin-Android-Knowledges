package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.easy

fun bonAppetit(bill: Array<Int>, k: Int, b: Int) {
    var totalPrice = 0

    for (i in bill.indices){
        if (i != k){
            totalPrice += bill[i]
        }
    }

    val extra = b - (totalPrice / 2)
    if (extra != 0)
        println(extra)
    else
        println("Bon Appetit")
}