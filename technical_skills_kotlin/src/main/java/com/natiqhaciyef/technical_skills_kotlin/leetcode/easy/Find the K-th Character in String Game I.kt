package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun kthCharacter(k: Int): Char {
    var str = "a"

    while(str.length < k) {
        var newStr = ""

        for(ch in str) {
            newStr += ch + 1
        }

        str += newStr
    }

    return str[k-1]
}