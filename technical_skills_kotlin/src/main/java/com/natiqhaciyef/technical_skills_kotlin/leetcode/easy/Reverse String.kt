package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun reverseString(s: CharArray): Unit {
    val halfSize = s.size/2
    val lastIndex =s.size - 1
    var temp: Char

    for(i in 0 until halfSize){
        temp = s[i]
        s[i] = s[lastIndex-i]
        s[lastIndex - i] = temp
    }
}
