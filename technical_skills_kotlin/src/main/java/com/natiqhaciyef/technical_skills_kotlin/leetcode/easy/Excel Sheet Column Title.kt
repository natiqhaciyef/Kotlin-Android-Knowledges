package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

private var result = ""
fun convertToTitle(columnNumber: Int): String {
    recursion(columnNumber)
    return result.reversed()
}

fun recursion(num: Int) {

//    println("num => $num")
    if (num <= 0) return
    if (num % 26 == 0 && num/26 == 1) {
        result += 'Z'
        return
    } else if(num % 26 == 0) {
        result += 'Z'

        recursion((num-26) / 26)
        return
    }else{
        result += ('A' + (num % 26 - 1))
    }

//    println(result)
    recursion(num / 26)
}

fun main() {
//    println(convertToTitle(1))
//    println(convertToTitle(52))
//    println(convertToTitle(26))
//    println(convertToTitle(729))
//    println(convertToTitle(701))
//    println(convertToTitle(676))
}