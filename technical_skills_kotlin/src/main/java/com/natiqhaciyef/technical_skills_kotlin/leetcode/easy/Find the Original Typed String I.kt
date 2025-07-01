package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun possibleStringCount(word: String): Int {
    var result = 1

    for(i in 1 until word.length){
        if(word[i] == word[i-1])
            result += 1
    }

    return result
}