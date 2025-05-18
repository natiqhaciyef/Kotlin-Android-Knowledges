package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

val result = mutableListOf<List<Int>>()
private val MOD = 1_000_000_007

// Main function to calculate number of valid grid colorings
fun colorTheGrid(m: Int, n: Int): Int {
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



    // Generate all valid colorings for a single column (no vertical adjacent cells share the same color)
    val states = generateValidStates(m)

    // Map each column state to its index for quick reference
    val stateToIndex = states.withIndex().associate { it.value to it.index }

    // Build transition list: for each state, find all valid next states (no horizontal color conflict)
    val transitions = buildTransitions(states)

    val k = states.size // Number of valid column states
    var dp = LongArray(k) { 1L } // Base case: each state is valid for the first column

    // Iterate through the columns (from second to nth)
    repeat(n - 1) {
        val nextDp = LongArray(k)
        for (i in 0 until k) {
            // For each valid transition from current state 'i' to 'j'
            for (j in transitions[i]) {
                nextDp[j] = (nextDp[j] + dp[i]) % MOD
            }
        }
        dp = nextDp // Move to next column
    }

    // Sum all ways to end at each state in the last column
    return dp.sum().toInt() % MOD
}

// Generate all valid column colorings of height m
fun generateValidStates(m: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    // Recursive backtracking to build each state
    fun backtrack(current: MutableList<Int>) {
        if (current.size == m) {
            result.add(current.toList())
            return
        }

        for (color in 0..2) {
            // Avoid same color as the cell directly above
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

// Build valid transitions between states (no two same colors in same row between adjacent columns)
fun buildTransitions(states: List<List<Int>>): List<List<Int>> {
    val transitions = MutableList(states.size) { mutableListOf<Int>() }
    for (i in states.indices) {
        for (j in states.indices) {
            if (isCompatible(states[i], states[j])) {
                transitions[i].add(j) // State j can follow state i
            }
        }
    }
    return transitions
}

// Check if two columns can be adjacent: no cell in the same row should have the same color
fun isCompatible(a: List<Int>, b: List<Int>): Boolean {
    for (i in a.indices) {
        if (a[i] == b[i]) return false // Conflict in same row
    }
    return true
}

// Example usage:
fun main() {
    println(colorTheGrid(1, 1)) // Output: 3
    println(colorTheGrid(1, 2)) // Output: 6
    println(colorTheGrid(5, 5)) // Output: 580986
}
