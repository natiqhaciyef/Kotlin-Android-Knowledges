package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun isPalindrome(x: Int): Boolean {
    val str = x.toString()
    val half = str.length/2
    for(i in 0 until half){
        if(str[i] != str[str.length-1-i])
            return false
    }

    return true
}