package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.array

fun reverseWords(s: String): String {
    var left = 0
    var right = s.length -1
    val current = StringBuilder(s)

    current.append("alma")

    while(left < right){
        val temp = current[left]
        current[left] = current[right]
        current[right] = temp

        left +=1
        right +=1
    }

    return s
}

fun main() {
    val str = StringBuilder("alma zad")
    str.insert(0, "geri ")
    str.removeRange(str.length-1 until str.length)
    println(str.toString())
}