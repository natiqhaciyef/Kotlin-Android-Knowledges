package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.array

//5 - 2
fun substringCopy(haystack: String, needle: String): String {
    var subs = 0
    var temp = needle

    //0
    for (i in haystack.indices) {
        if (subs == needle.length)
            temp += haystack[i]
        else if (haystack[i] == needle[subs])
            subs += 1
        else
            subs = 0


        if (haystack.length - i < needle.length)
            return ""
    }

    return if (temp == needle) return "" else temp
}

fun main() {
    println(substringCopy("almabala", "b"))
}