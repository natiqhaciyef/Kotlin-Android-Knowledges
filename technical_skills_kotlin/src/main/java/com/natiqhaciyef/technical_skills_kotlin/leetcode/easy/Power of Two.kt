package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun isPowerOfTwo(n: Int): Boolean {
    if (n < 1) return false
    if(n == 1) return true

    var num = n

    while(num > 1){
        if(num % 2 != 0)
            return false

        num /= 2
    }

    return true
}