package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


/**
               j
        |    | "" | r | o | s |
        | -- | -- | - | - | - |
    i   | "" | 0  | 1 | 2 | 3 |
        | h  | 1  | 1 | 2 | 3 |
        | o  | 2  | 2 | 1 | 2 |
        | r  | 3  | 2 | 2 | 2 |
        | s  | 4  | 3 | 3 | 2 |
        | e  | 5  | 4 | 4 | 3 |

 */

fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    // Fill base cases
    for (i in 0..m) dp[i][0] = i // word1 to empty word2

    for (j in 0..n) dp[0][j] = j // empty word1 to word2

    for(i in 1..m){

        for(j in 1..n){
            if(word1[i-1] == word2[j-1]){
                // remains current state
                dp[i][j] = dp[i-1][j-1]
            }else{
                dp[i][j] = minOf(
                    dp[i][j-1] + 1,     // insert word1
                    dp[i-1][j] + 1,     // remove word1
                    dp[i-1][j-1] + 1,   // replace word1
                )
            }
        }

    }

    return dp[m][n]
}

