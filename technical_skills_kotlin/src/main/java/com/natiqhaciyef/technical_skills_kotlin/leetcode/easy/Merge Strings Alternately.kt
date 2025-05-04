package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun mergeAlternately(word1: String, word2: String): String {
    var result = ""
    val size = minOf(word1.length, word2.length)
    var pointer = 0

    while(pointer < size){
        result += word1[pointer]
        result += word2[pointer]
        pointer +=1
    }

    while(pointer < word1.length){
        result += word1[pointer]
        pointer +=1
    }

    while(pointer < word2.length){
        result += word2[pointer]
        pointer +=1
    }

    return result
}
