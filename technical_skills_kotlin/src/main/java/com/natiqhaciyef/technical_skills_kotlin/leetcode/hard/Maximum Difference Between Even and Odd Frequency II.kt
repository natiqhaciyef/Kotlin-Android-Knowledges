package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard


import kotlin.math.max
import kotlin.math.min

/**
 * A Segment Tree implementation for finding the minimum value in a given range.
 * This is crucial for the optimized solution to quickly find the best substring start point.
 */
class SegmentTree(size: Int) {
    // The tree is 1-indexed for easier parent/child calculations.
    // It stores the minimum value found in the range represented by each node.
    private val tree: IntArray
    private val n: Int = size

    companion object {
        // A value representing infinity, used when a range is empty or invalid.
        const val INFINITY = Int.MAX_VALUE
    }

    init {
        // The required size of the array for the segment tree is ~4 times the number of elements.
        tree = IntArray(4 * n) { INFINITY }
    }

    /**
     * Updates the value at a specific index in the original array and propagates the change up the tree.
     * The tree stores minimums, so parent nodes are updated to be the minimum of their children.
     *
     * @param index The index to update (0-based).
     * @param value The new value for that index.
     */
    fun update(index: Int, value: Int) {
        updateRec(1, 0, n - 1, index, value)
    }

    private fun updateRec(node: Int, start: Int, end: Int, idx: Int, value: Int) {
        if (start == end) {
            // Leaf node: update the value directly.
            tree[node] = min(tree[node], value)
            return
        }
        val mid = (start + end) / 2
        if (idx in start..mid) {
            // Index is in the left child's range.
            updateRec(2 * node, start, mid, idx, value)
        } else {
            // Index is in the right child's range.
            updateRec(2 * node + 1, mid + 1, end, idx, value)
        }
        // After child update, update the parent node to be the minimum of its children.
        tree[node] = min(tree[2 * node], tree[2 * node + 1])
    }

    /**
     * Queries for the minimum value in a given range [l, r].
     *
     * @param l The left boundary of the query range (inclusive).
     * @param r The right boundary of the query range (inclusive).
     * @return The minimum value in the range, or INFINITY if the range is invalid or empty.
     */
    fun query(l: Int, r: Int): Int {
        if (l > r) return INFINITY
        return queryRec(1, 0, n - 1, l, r)
    }

    private fun queryRec(node: Int, start: Int, end: Int, l: Int, r: Int): Int {
        if (r < start || end < l) {
            // The query range is completely outside the node's range.
            return INFINITY
        }
        if (l <= start && end <= r) {
            // The node's range is completely inside the query range.
            return tree[node]
        }
        // The node's range partially overlaps with the query range.
        // Recurse on children and return the minimum of their results.
        val mid = (start + end) / 2
        val p1 = queryRec(2 * node, start, mid, l, r)
        val p2 = queryRec(2 * node + 1, mid + 1, end, l, r)
        return min(p1, p2)
    }
}

/**
 * Calculates the maximum difference between the frequencies of two characters in any substring
 * of length at least k, such that the first character's frequency is odd and the second's is even and non-zero.
 *
 * Time Complexity: O(C^2 * N * log N), where C is the alphabet size (5) and N is the string length.
 * Since C is a small constant, this simplifies to O(N log N).
 * Space Complexity: O(C * N) for prefix sums and O(C^2 * N) for segment trees, simplifying to O(N).
 *
 * @param s The input string containing digits '0' through '4'.
 * @param k The minimum length of the substring.
 * @return The maximum difference found, or Int.MIN_VALUE if no such valid substring exists.
 */
fun maxDifference(s: String, k: Int): Int {
    val n = s.length
    if (n < k) {
        return Int.MIN_VALUE // No possible substring of length k
    }

    // 1. Pre-calculate prefix sums for each character ('0' to '4')
    // prefixSums[c][i] = count of character c in the prefix s[0...i-1]
    val prefixSums = Array(5) { IntArray(n + 1) }
    for (i in 0 until n) {
        for (c in 0..4) {
            prefixSums[c][i + 1] = prefixSums[c][i]
        }
        prefixSums[s[i] - '0'][i + 1]++
    }

    var maxResult = Int.MIN_VALUE

    // 2. Iterate through all possible pairs of distinct characters (c1, c2)
    // c1: character with ODD frequency
    // c2: character with EVEN, NON-ZERO frequency
    for (c1 in 0..4) {
        for (c2 in 0..4) {
            if (c1 == c2) continue

            // 3. For each (c1, c2) pair, use segment trees to find the optimal substring.
            // We need 4 segment trees to handle the 4 parity combinations of (prefixSum[c1], prefixSum[c2]).
            // This allows us to enforce the odd/even frequency constraints efficiently.
            // trees[p1][p2] stores min(prefixSum[c1][i] - prefixSum[c2][i]) for start indices `i`
            // where prefixSum[c1][i] has parity p1 and prefixSum[c2][i] has parity p2.
            val trees = Array(2) { Array(2) { SegmentTree(n + 1) } }

            // The first possible start point `i` for a substring of length `k` is 0.
            // We add it to the segment tree before the main loop.
            val p1Initial = prefixSums[c1][0] % 2
            val p2Initial = prefixSums[c2][0] % 2
            trees[p1Initial][p2Initial].update(
                prefixSums[c2][0],
                prefixSums[c1][0] - prefixSums[c2][0]
            )


            // 4. Iterate through all possible substring end points `j`.
            // The substring is s[i...j-1]
            for (j in k..n) {
                val currentP1 = prefixSums[c1][j]
                val currentP2 = prefixSums[c2][j]

                // We need to find a starting prefix `i` such that:
                // a) freq(c1) = currentP1 - prefixSums[c1][i] is ODD
                // b) freq(c2) = currentP2 - prefixSums[c2][i] is EVEN

                // This implies:
                // a) parity(prefixSums[c1][i]) != parity(currentP1)
                // b) parity(prefixSums[c2][i]) == parity(currentP2)
                val targetP1Parity = 1 - (currentP1 % 2)
                val targetP2Parity = currentP2 % 2

                // We also need freq(c2) > 0, which means prefixSums[c2][i] < currentP2.
                // So we query for the minimum value in the required range.
                val queryRangeEnd = currentP2 - 1
                val relevantTree = trees[targetP1Parity][targetP2Parity]

                val minVal = relevantTree.query(0, queryRangeEnd)

                if (minVal != SegmentTree.INFINITY) {
                    // We found a valid starting point `i`.
                    // The difference is (currentP1 - currentP2) - min(prefixSums[c1][i] - prefixSums[c2][i])
                    val currentDiff = (currentP1 - currentP2) - minVal
                    maxResult = max(maxResult, currentDiff)
                }

                // 5. Add the next potential starting point to the segment trees for future iterations.
                // A substring ending at `j` gives us a new potential starting point at `j - k + 1`.
                val startIdx = j - k + 1
                if (startIdx <= n) {
                    val p1 = prefixSums[c1][startIdx] % 2
                    val p2 = prefixSums[c2][startIdx] % 2
                    val value = prefixSums[c1][startIdx] - prefixSums[c2][startIdx]
                    trees[p1][p2].update(prefixSums[c2][startIdx], value)
                }
            }
        }
    }

    return maxResult
}

