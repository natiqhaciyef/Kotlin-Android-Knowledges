package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview


fun wordPattern(pattern: String, s: String): Boolean {
    val hashMap = hashMapOf<Char, String>()
    val list = splitter(s)
    println(list)

    if (list.size != pattern.length)
        return false

    for (index in pattern.indices) {
        if (hashMap.containsKey(pattern[index])) {
            if (list[index] != hashMap[pattern[index]])
                return false
        } else {
            if (!hashMap.containsValue(list[index]))
                hashMap[pattern[index]] = list[index]
            else
                return false
        }
    }

    return true
}

fun splitter(s: String): List<String> {
    val list = mutableListOf<String>()
    var temp = ""
    val customS = "$s "
    for (index in customS.indices) {
        if (customS[index] == ' ') {
            list.add(temp)
            temp = ""
        } else
            temp += customS[index]

    }

    return list
}

fun main() {
    val pattern = "abba"
    val sentence = "dog cat cat dog"
    println(wordPattern(pattern, sentence))
}