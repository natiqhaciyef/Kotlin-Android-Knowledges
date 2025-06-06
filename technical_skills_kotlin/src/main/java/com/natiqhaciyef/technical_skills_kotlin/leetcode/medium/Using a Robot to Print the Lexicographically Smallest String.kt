package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun robotWithString(s: String): String {
    // Topics: HashTable, String, Stack, Greedy
    val minSuffix = CharArray(s.length) { 'z' + 1 }
    var minChar = 'z' + 1

    // Compute min suffix char for each position
    for (i in s.length - 1 downTo 0) {
        minChar = minOf(minChar, s[i])
        minSuffix[i] = minChar
    }

    val t = ArrayDeque<Char>()
    val result = StringBuilder()
    var i = 0

    while (i < s.length || t.isNotEmpty()) {

        if (i < s.length) {
            t.addLast(s[i])
            i++
        }

        // If t’s top is ≤ the smallest char left in s
        while (t.isNotEmpty() && (i == s.length || t.last() <= minSuffix[i])) {
            result.append(t.removeLast())
        }
    }

    return result.toString()
}