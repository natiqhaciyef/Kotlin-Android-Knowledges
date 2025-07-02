package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard


private val MOD = 1000000007L
fun possibleStringCount(word: String, k: Int): Int {
    // Topics: String, Dynamic Programming, Prefix Sum

    val repeatedChar = mutableListOf<Int>()
    var counter = 1

    for(i in 1 until word.length){
        if(word[i] == word[i-1]){
            counter += 1
        }else{
            repeatedChar.add(counter)
            counter = 1
        }
    }

    repeatedChar.add(counter)

    var totalCount = 1L
    for(num in repeatedChar){
        totalCount = (totalCount * num) % MOD
    }

    if(k <= repeatedChar.size){
        return (totalCount % MOD).toInt()
    }

    var dp = IntArray(k)
    dp[0] = 1

    for (i in repeatedChar) {
        val newDp = IntArray(k)
        var sum = 0L

        println("repeated $i times")
        for (j in 0 until k) {
            if (j > 0) {
                sum = (sum + dp[j - 1]) % MOD
            }
            if (j > i) {
                sum = (sum - dp[j - i - 1] + MOD) % MOD
            }
            newDp[j] = sum.toInt()
        }
        dp = newDp
        println(newDp.toMutableList())
    }

    var invalid = 0L
    for (i in repeatedChar.size until k) {
        invalid = (invalid + dp[i]) % MOD
    }


    return ((totalCount - invalid + MOD) % MOD).toInt()
}


fun main() {
    possibleStringCount(word = "aabbccdd", 7)
}