package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import kotlin.math.pow

fun longestSubsequence(s: String, k: Int): Int {
    // Topics: String, Greedy, Memoization, Dynamic Programming
    // Conditions:
    //  - substring <= k
    //  - possible leading zeroes
    //  - empty string = 0
    //  - without change order only reduce length of string but we can add 0 to the start of the string

    // stages
    // find count of zeroes
    // convert k to binary representation and reverse converter
    // find substrings that lower than k


    fun intToBinary(value: Int): String {
        var result = ""

        var current = value

        while(current > 0) {
            result += "${current % 2}"

            current /= 2
        }

        return result.reversed()
    }

    fun binaryToInt(value: String): Int {
        var num = 0.0

        //0101
        for(i in value.reversed().indices){
            if(value[value.length - i - 1] == '0') continue

            num += 2.0.pow(i)
        }

        return num.toInt()
    }

    var result = ""
    var zeroes = ""
    var curr = s

    while(curr.isNotEmpty()){

        if(binaryToInt(curr) <= k) {
            // println(curr)
            // println(binaryToInt(curr))
            // println("-----")

            result = zeroes + curr
            break
        }

        if(curr[0] == '0')
            zeroes += "0"

        curr = curr.substring(1 until curr.length)
    }

    // println("result => $result")

    return result.length
}
