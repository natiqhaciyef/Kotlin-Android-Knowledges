package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

//Example 1:
//Input: strs = ["flower","flow","flight"]
//Output: "fl"

//Example 2:
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.

fun longestCommonPrefixBest(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    var prefix = strs[0]
    for (i in 1 until strs.size) {

        while (strs[i].indexOf(prefix) != 0) {

            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }
    }
    return prefix
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs[0]

    val temp = strs[0]
    var pref = ""
    for (i in temp.indices) {
        if (strs.all { it.startsWith(temp.substring(0 .. i)) })
            pref = temp.substring(0 .. i)
    }

    return pref
}

fun main() {
    val strs1 = arrayOf("flower", "flow", "flight")
    val strs2 = arrayOf("dog", "racecar", "car")
    val strs3 = arrayOf("", "b")
    val strs4 = arrayOf("alam", "electric", "element")
    val strs5 = arrayOf("flower", "flower", "flower", "flower")

    println(longestCommonPrefix(strs1))
    println(longestCommonPrefix(strs2))
    println(longestCommonPrefix(strs3))
    println(longestCommonPrefix(strs4))
    println(longestCommonPrefix(strs5))
}