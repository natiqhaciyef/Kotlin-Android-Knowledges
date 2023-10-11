package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.easy

fun longestCommonPrefix(strs: Array<String>): String {
    val pref = mutableListOf<String>()

    if (strs.toSet().size == 1)
        return strs[0]

    if (strs.size > 1) {
        for (str in strs) {
            var emptyField = ""
            for (i in str.indices) {
                if (emptyField.isNotEmpty()) {
                    val count = strs.filter { it.startsWith(emptyField) }.count()
                    if (count == strs.size) {
                        pref.add(emptyField)
                        println(pref)
                    }
                }
                emptyField += str[i]
            }
        }
    } else {
        return if (strs.isNotEmpty()) strs[0] else ""
    }

    return if (pref.isNotEmpty()) {
        var findMax = pref[0]
        for (pre in pref) {
            if (pre.length > findMax.length)
                findMax = pre
        }
        findMax

    } else {
        ""
    }
}


fun longestCommonPrefixOptimized(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }

    // Find the shortest string in the array
    val shortest = strs.minByOrNull { it.length }!!

    for (i in shortest.indices) {
        val char = shortest[i]

        // Check if the current character exists in the same position in all strings
        if (strs.any { it.length <= i || it[i] != char }) {
            return shortest.substring(0, i)
        }
    }

    return shortest // The shortest string is the common prefix
}

fun main() {

    println(longestCommonPrefix(arrayOf("aaa", "aa", "aaa")))
    println(longestCommonPrefix(arrayOf("aaba", "aaa", "aa", "aa", "aa", "aa")))
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("acc", "aaa", "aaba")))
    println(longestCommonPrefix(arrayOf("flower", "flower", "flower", "flower")))

    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}

