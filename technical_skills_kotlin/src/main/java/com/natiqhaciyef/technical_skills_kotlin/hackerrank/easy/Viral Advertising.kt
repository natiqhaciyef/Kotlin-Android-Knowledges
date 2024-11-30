package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

fun viralAdvertising(n: Int): Int {
    var totalShared = 0
    var shared = 0
    var default = 5

    for (stage in 1 .. n) {
        shared = default / 2
        default = shared * 3
        totalShared += shared
    }

    return totalShared
}

fun main() {
    println(viralAdvertising(5))
}