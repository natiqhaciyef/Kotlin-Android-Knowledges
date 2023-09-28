package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.easy


//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000


fun romanToInt(s: String): Int {
    val counter = mutableListOf<Int>()
    var sum = 0

    for (i in s) {
        counter.add(romanNumberToNormal(i).toInt())
    }

    for (index in counter.indices) {
        var element = counter[index]

        for (j in 0..index) {
            if (element > counter[j]) {
                element -= counter[j] * 2
            }
        }
        sum += element
    }

    println(counter)
    println(sum)
    return 0
}

fun romanNumberToNormal(c: Char) = when (c) {
    'I' -> {
        "1"
    }

    'V' -> {
        "5"
    }

    'X' -> {
        "10"
    }

    'L' -> {
        "50"
    }

    'C' -> {
        "100"
    }

    'D' -> {
        "500"
    }

    'M' -> {
        "1000"
    }

    else -> {
        "1"
    }
}


fun main() {
    romanToInt("III")

    val d1 = 118.41172464
    val d2 = -123.12390389
    println(d2 is Double)
}