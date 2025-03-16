package com.natiqhaciyef.technical_skills_kotlin.interview

fun strStr(haystack: String, needle: String): Int {
    if (haystack == needle || haystack.startsWith(needle))
        return 0


    val sizeOfNeedle = needle.length

    for (i in 0 .. haystack.length - sizeOfNeedle) {
        val element = haystack.substring(i until i + sizeOfNeedle)
        if (element == needle)
            return i
    }

    return -1
}

//Example 1:
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.

//Example 2:
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.

fun main() {
    val s1 = "sadbutsad"
    val n1 = "sad"
    println(strStr(s1, n1))

    val s2 = "leetcode"
    val n2 = "leeto"
    println(strStr(s2, n2))

    val s3 = "abc"
    val n3 = "c"
    println(strStr(s3, n3))
}