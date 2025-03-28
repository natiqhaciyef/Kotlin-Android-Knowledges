package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordSet = wordDict.toSet()
    val dp = BooleanArray(s.length + 1)
    dp[0] = true

    for (i in 1..s.length) {
        for (j in 0 until i) {
            print(s.substring(j, i))
            print(" ")
            if (dp[j] && s.substring(j, i) in wordSet) {
                println(wordSet)
                dp[i] = true
                println(dp[i])
                break
            }
        }

        println("")
    }

    println(dp.toList())
    return dp[s.length]
}

fun main() {
    val s = "leetcode"
    val wordDict = listOf("leet", "code")

    val s2 = "catsandog"
    val wordDict2 = listOf("cats", "dog", "sand", "and", "cat")

//    println(wordBreak(s, wordDict)) // Output: true
    println(wordBreak(s2, wordDict2)) // Output: false
}
