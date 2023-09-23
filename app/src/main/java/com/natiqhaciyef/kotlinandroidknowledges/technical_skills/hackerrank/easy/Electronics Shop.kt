package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.easy

fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
    var max = -1

    for (keyboard in keyboards){
        for (drive in drives){
            val sum = keyboard + drive
            if (sum in (max + 1)..b)
                max = sum
        }
    }
    return max
}