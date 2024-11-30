package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import java.lang.Math.pow
import kotlin.reflect.typeOf

fun myAtoi(s: String): Int {
    var num = ""
    val numbers = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")


    if (s.contains("+-") || s.contains("-+") || s.contains(" + ") || s.contains(" - "))
        return 0

    for (char in s) {
        if (!numbers.contains(char.toString()) && char != '-' && char != '+' && char != ' ')
            break

        if (num.isNotEmpty() && !numbers.contains(char.toString()))
            break

        if (numbers.contains(char.toString()))
            num += char
    }


    if (num.isEmpty())
        return 0

    if(s.trim().contains(" ") && (!s.trim().startsWith(num) && !s.trim().startsWith("-$num")))
        return 0


    if(num.length >= 19 && s.contains("-$num"))
        return (-1 * pow(2.0, 31.0)).toInt()
    else if(num.length >= 19 && !s.contains("-$num"))
        return (pow(2.0, 31.0) - 1).toInt()


    if (num.toLong() > (pow(2.0, 31.0) - 1) && !s.contains("-$num")) {
        return (pow(2.0, 31.0) - 1).toInt()
    } else if (s.contains("-$num") && num.toLong() > pow(2.0, 31.0))
        return (-1 * pow(2.0, 31.0)).toInt()

    return if (s.contains("-$num")) (-1 * num.toLong()).toInt() else num.toInt()
}

fun main() {
    println(myAtoi(" + 413"))
    println(myAtoi("  413 +"))
    println(myAtoi("9223372036854775808"))
    println(myAtoi("20000000000000000000"))
    println(myAtoi("-20000000000000000000"))
    println(myAtoi("words and 987"))
    println(myAtoi("-91283472332"))
    println(myAtoi("-2147483648"))
    println(myAtoi("00000-42a1234"))
    println(myAtoi("   -42"))
    println(myAtoi("   -6 5"))
    println(myAtoi("  +0 123"))
    println(myAtoi("42"))
    println(myAtoi("    -88827   5655  U"))

}