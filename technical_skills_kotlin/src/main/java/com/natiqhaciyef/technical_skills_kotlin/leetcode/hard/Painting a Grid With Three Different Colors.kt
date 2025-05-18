package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

private val MOD = 1_000_000_007
val result = mutableListOf<List<Int>>()

fun colorTheGrid(m: Int, n: Int): Long {
    // Topic: Dynamic Programming

    // Inputs
    // 1 + 1 => 3
    // 1 + 2 => 6
    // 1 + 3 => 12
    // 1 + 4 => 24

    // 2 + 1 => 6
    // 2 + 2 => 18
    // 2 + 3 => 54
    // 2 + 4 => 162

    // First input are the power of 3*2^(n-1)
    // Second input are the power of 3*3^(n-1)


    // But after first two inputs game changes and there is no any logical approach
    // 3 + 1 => 12
    // 3 + 2 => 54
    // 3 + 3 => 246 (216 + 30)
    // 3 + 4 => 1122 (984 + 138)


    // Red = 0
    // Blue = 1
    // Green = 2
    val states = generateValidStates(m)
    val stateToIndex = states.withIndex().associate { it.value to it.index }
    val transitions = buildTransitions(states)

    val k = states.size
    var dp = LongArray(k) { 1L } // base case: first column

    repeat(n - 1) {
        val nextDp = LongArray(k)
        for (i in 0 until k) {
            for (j in transitions[i]) {
                nextDp[j] = (nextDp[j] + dp[i]) % MOD
            }
        }
        dp = nextDp
    }

    return dp.sum().toLong() % MOD
}

fun generateValidStates(m: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun backtrack(current: MutableList<Int>) {
        if (current.size == m) {
            result.add(current.toList())
            return
        }

        for (color in 0..2) {
            if (current.isEmpty() || current.last() != color) {
                current.add(color)
                backtrack(current)
                current.removeAt(current.size - 1)
            }
        }
    }

    backtrack(mutableListOf())
    return result
}

fun buildTransitions(states: List<List<Int>>): List<List<Int>> {
    val transitions = MutableList(states.size) { mutableListOf<Int>() }
    for (i in states.indices) {
        for (j in states.indices) {
            if (isCompatible(states[i], states[j])) {
                transitions[i].add(j)
            }
        }
    }
    return transitions
}

fun isCompatible(a: List<Int>, b: List<Int>): Boolean {
    for (i in a.indices) {
        if (a[i] == b[i]) return false
    }
    return true
}
