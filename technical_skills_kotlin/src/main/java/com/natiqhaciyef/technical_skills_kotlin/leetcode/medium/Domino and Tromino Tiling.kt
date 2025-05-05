package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

/***
 *
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
 * Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large,
 * return it modulo 109 + 7.
 * In a tiling, every square must be covered by a tile. Two tilings are different if and only if there
 * are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
 *
 * Example 1:
 * Input: n = 3
 * Output: 5
 * Explanation: The five different ways are show above.
 *
 *
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 *
 *
 * Constraints:
 * 1 <= n <= 1000
 *
 */

fun numTilings(n: Int): Long {
    val MOD = 1_000_000_007

    // H = Horizontal
    // V = Vertical
    // L = Tromino

    // Default
    // 1 -> 1
    // 2 -> 2
    // 3 -> 5

    // Sequence (Bottom Up memoizing)
    // 4 -> f(n-1) * 2 + f(n-3)

    val list = mutableListOf<Long>()
    list.add(0L)
    list.add(1L)
    list.add(2L)
    list.add(5L)

    if(n <= 3) return list[n] ?: 0L

    for(i in 4 .. n){
        val prev = list[i-1]
        val add = list[i-3]

        // modulo adding here because expected result could be over the limit of Long
        val result = ((prev * 2L) % MOD + add) % MOD
        list.add(result)
    }

    return list[n] ?: 0L
}
