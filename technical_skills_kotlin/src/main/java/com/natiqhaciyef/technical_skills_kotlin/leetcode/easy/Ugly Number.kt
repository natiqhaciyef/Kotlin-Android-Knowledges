package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun isUgly(n: Int): Boolean {
    if(n <= 0) return false
    if(n in 1 .. 6) return true
    var current = n
    while(current > 1){
        current /= when{
            current % 2 == 0 -> 2
            current % 3 == 0 -> 3
            current % 5 == 0 -> 5
            else ->{return false}
        }
    }

    return true
}

fun main() {

}