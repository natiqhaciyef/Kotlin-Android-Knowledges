package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun addDigits(num: Int): Int {
    var result = num
    while(result > 9){
        result = sumOfDigits(result)
    }

    return result
}


fun sumOfDigits(num: Int): Int{
    var sum = 0
    var current = num
    while(current > 0){
        sum += current % 10
        current /= 10
    }

    return sum
}