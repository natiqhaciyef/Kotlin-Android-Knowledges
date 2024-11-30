package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

fun utopianTree(n: Int): Int {
    var height = 0

    for (i in 0..n){
        if (i % 2 == 0)
            height += 1
        else
            height *= 2
    }

    return height
}


fun main() {
    println(utopianTree(5))
}