package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun lengthOfLastWord(s: String): Int {
    val trimmedS = s.trimEnd()
    var temp = ""

    for (i in trimmedS.length - 1 downTo 0) {
        if (s[i] != ' ')
            temp += s[i]
        else
            return temp.length
    }

    return temp.length
}