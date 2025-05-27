package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun differenceOfSums(n: Int, m: Int): Int {
    var div = 0
    var non = 0

    for(i in 1 .. n){
        if(i % m == 0)
            div += i
        else
            non += i
    }

    return non - div
}