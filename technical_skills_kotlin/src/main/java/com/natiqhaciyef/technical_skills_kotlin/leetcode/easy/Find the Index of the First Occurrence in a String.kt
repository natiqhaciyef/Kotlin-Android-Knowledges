package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun strStr(haystack: String, needle: String): Int {
    if (haystack.startsWith(needle))
        return 0

    val sizeOfNeedle = needle.length
    var element = ""

    for (i in 0 .. haystack.length - sizeOfNeedle) {
        element = haystack.substring(i until i + sizeOfNeedle)
        if (element == needle)
            return i
    }

    return -1
}