package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import kotlin.math.abs

/**
 * Finds the maximum Manhattan distance from the origin that can be achieved.
 *
 * @param s The string of movements.
 * @param k The maximum number of characters that can be changed.
 * @return The maximum achievable Manhattan distance.
 */
fun maxManhattanDistance(s: String, k: Int): Int {
    var low = 0
    var high = s.length
    var ans = 0


    while (low <= high) {
        val mid = low + (high - low) / 2

        if (isAchievable(mid.toLong(), s, k)) {
            ans = mid
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return ans
}

/**
 * Checks if a Manhattan distance of D is achievable by checking four diagonal directions.
 */
private fun isAchievable(D: Long, s: String, k: Int): Boolean {
    return checkDirection("NE", D, s, k) ||
            checkDirection("NW", D, s, k) ||
            checkDirection("SE", D, s, k) ||
            checkDirection("SW", D, s, k)
}

/**
 * Checks if a value of at least D can be achieved for a specific directional sum (e.g., x + y).
 *
 * @param positiveDirs A string containing the two characters considered "positive" for this direction.
 * @param D The target distance/sum.
 */
private fun checkDirection(positiveDirs: String, D: Long, s: String, k: Int): Boolean {
    val n = s.length
    val prefixSum = LongArray(n + 1)
    val negativeMovesCount = IntArray(n + 1)


    for (i in 0 until n) {
        val char = s[i]
        val value = if (char in positiveDirs) 1 else -1

        prefixSum[i + 1] = prefixSum[i] + value
        negativeMovesCount[i + 1] = negativeMovesCount[i] + if (value == -1) 1 else 0
    }


    for (t in 1..n) {
        val currentSum = prefixSum[t]
        val availableToChange = negativeMovesCount[t]


        if (currentSum >= D) {
            return true
        }


        val neededGain = D - currentSum

        val cost = (neededGain + 1) / 2


        if (cost <= k && cost <= availableToChange) {
            return true
        }
    }

    return false
}

fun main() {
    println("---- Result 1 ----")
    println(maxManhattanDistance("NWSE", 1))

    println("---- Result 2 ----")
    println(maxManhattanDistance("NSWWEW", 3))

    println("---- Result 3 ----")
    println(maxManhattanDistance("NW", 2))
}