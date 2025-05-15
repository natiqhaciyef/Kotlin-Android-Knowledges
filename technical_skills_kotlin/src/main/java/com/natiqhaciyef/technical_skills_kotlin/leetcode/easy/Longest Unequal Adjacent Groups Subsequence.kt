package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    // Topics: Array, String, Dynamic Programming, Greedy
    fun buildSubsequence(startGroup: Int): List<String> {
        val result = mutableListOf<String>()
        var expected = startGroup
        for (i in words.indices) {
            if (groups[i] == expected) {
                result.add(words[i])
                expected = 1 - expected // Alternate between 0 and 1
            }
        }
        return result
    }

    // Try starting with group 0 and group 1, return the longer one
    val option1 = buildSubsequence(0)
    val option2 = buildSubsequence(1)

    return if (option1.size >= option2.size) option1 else option2
}