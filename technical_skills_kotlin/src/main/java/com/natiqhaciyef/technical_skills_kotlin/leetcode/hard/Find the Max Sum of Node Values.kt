package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

import java.util.ArrayList
import kotlin.math.max


/***
 *
 * The problem asks us to find the maximum possible sum of node values in a tree. We can perform an operation any number of times: choose an edge (u, v) and update nums[u] = nums[u] XOR k and nums[v] = nums[v] XOR k.
 *
 * Understanding the Operation
 *
 * Consider the effect of applying the operation on a path of edges. If we apply the operation on all edges along the unique path between two nodes a and b:
 *
 * Nodes a and b (the endpoints of the path) will have their values XORed with k.
 * Any intermediate node w on the path will be part of two operations (one for edge (prev_w, w) and one for (w, next_w)). Thus, its value becomes (nums[w] XOR k) XOR k = nums[w], meaning it's unchanged.
 * Nodes not on the path are unaffected.
 * This implies that one "effective" operation is to pick any two nodes a and b and XOR their values with k.
 * If we want to change the value of nums[i] to nums[i] XOR k, we can think of this as "flipping" the state of node i. Each fundamental operation on an edge flips the state of two nodes. Therefore, if we perform a sequence of operations, the total number of nodes whose states are ultimately flipped must be even.
 *
 * Problem Refreshment
 * The problem then becomes: for each node i, we can either keep its value as nums[i] or change it to nums[i] XOR k. We need to choose a subset of nodes S to apply the XOR k operation, such that the size of S (|S|) is even, and the total sum of values in the tree is maximized.
 *
 * The sum can be written as: sum_{i not in S} nums[i] + sum_{i in S} (nums[i] XOR k).
 * This is equivalent to: sum_{all i} nums[i] + sum_{i in S} ((nums[i] XOR k) - nums[i]).
 * To maximize this, we want to maximize sum_{i in S} delta[i], where delta[i] = (nums[i] XOR k) - nums[i], under the constraint that |S| is even.
 *
 * Dynamic Programming on Tree
 * We can solve this using dynamic programming on the tree. Let's root the tree arbitrarily (e.g., at node 0).
 * For each node u, we want to compute two values:
 *
 * dp[u][0]: The maximum possible sum for the subtree rooted at u, assuming an even number of nodes within this subtree (including u itself) have their values XORed with k.
 * dp[u][1]: The maximum possible sum for the subtree rooted at u, assuming an odd number of nodes within this subtree (including u itself) have their values XORed with k.
 * The final answer will be dp[root][0], as we need an even number of XORed nodes in the entire tree.
 *
 * DFS Implementation
 * We'll use a Depth First Search (DFS) function, say dfs(u, parent), which returns a pair (max_sum_even_flips, max_sum_odd_flips) for the subtree rooted at u.
 *
 * Base Case (Leaf Node u):
 * If u is not XORed (0 flips in this subtree): sum is nums[u]. This contributes to dp[u][0].
 * If u is XORed (1 flip in this subtree): sum is nums[u] XOR k. This contributes to dp[u][1]. So, for a leaf u, dfs(u, p) returns (nums[u].toLong(), (nums[u] XOR k).toLong()).
 * Recursive Step (Internal Node u):
 * Initialize children_combined_even_sum = 0L (sum if children contribute an even number of flips) and children_combined_odd_sum = Long.MIN_VALUE (sum if children contribute an odd number of flips; initially impossible).
 *
 * For each child v of u:
 * Recursively call (child_even_sum, child_odd_sum) = dfs(v, u).
 * Update children_combined_even_sum and children_combined_odd_sum by considering combinations:
 * new_even = max( (prev_even + child_even), (prev_odd + child_odd) )
 * new_odd = max( (prev_even + child_odd), (prev_odd + child_even) ) (Handle Long.MIN_VALUE carefully: if a component sum is Long.MIN_VALUE, that path is invalid).
 * After processing all children, calculate dp[u][0] and dp[u][1]:
 * Let val_u_normal = nums[u].toLong() and val_u_xor = (nums[u] XOR k).toLong().
 * Initialize res_u_even = Long.MIN_VALUE, res_u_odd = Long.MIN_VALUE.
 *
 * If node u is NOT XORed (contributes 0 to flip parity):
 * To get even total flips for u's subtree: children must contribute even flips. If children_combined_even_sum != Long.MIN_VALUE, then res_u_even = max(res_u_even, val_u_normal + children_combined_even_sum).
 * To get odd total flips for u's subtree: children must contribute odd flips. If children_combined_odd_sum != Long.MIN_VALUE, then res_u_odd = max(res_u_odd, val_u_normal + children_combined_odd_sum).
 * If node u IS XORed (contributes 1 to flip parity):
 *
 * To get even total flips for u's subtree: children must contribute odd flips (1 + odd = even). If children_combined_odd_sum != Long.MIN_VALUE, then res_u_even = max(res_u_even, val_u_xor + children_combined_odd_sum).
 * To get odd total flips for u's subtree: children must contribute even flips (1 + even = odd). If children_combined_even_sum != Long.MIN_VALUE, then res_u_odd = max(res_u_odd, val_u_xor + children_combined_even_sum).
 * Return (res_u_even, res_u_odd).
 *
 * The final answer is the first element of the pair returned by dfs(0, -1) (assuming node 0 as root).
 */

private lateinit var adj: Array<MutableList<Int>>
private lateinit var nums: IntArray
private var kValue: Int = 0

// Pair: (max_sum_for_even_flips_in_subtree, max_sum_for_odd_flips_in_subtree)
private fun dfs(u: Int, p: Int): Pair<Long, Long> {
    // Base for combining children results:
    // If no children, effectively 0 sum from children, and 0 (even) flips from children.
    var childrenCombinedEvenSum = 0L
    var childrenCombinedOddSum = Long.MIN_VALUE // Impossible to get odd flips from no children

    for (v in adj[u]) {
        if (v == p) continue

        val (childEvenSum, childOddSum) = dfs(v, u)

        val nextChildrenCombinedEvenSum = Long.MIN_VALUE
        val nextChildrenCombinedOddSum = Long.MIN_VALUE

        // Try to update nextChildrenCombinedEvenSum
        var tempNextEven = Long.MIN_VALUE
        if (childrenCombinedEvenSum != Long.MIN_VALUE && childEvenSum != Long.MIN_VALUE) {
            tempNextEven =
                max(tempNextEven, childrenCombinedEvenSum + childEvenSum) // even + even = even
        }
        if (childrenCombinedOddSum != Long.MIN_VALUE && childOddSum != Long.MIN_VALUE) {
            tempNextEven =
                max(tempNextEven, childrenCombinedOddSum + childOddSum) // odd + odd = even
        }

        // Try to update nextChildrenCombinedOddSum
        var tempNextOdd = Long.MIN_VALUE
        if (childrenCombinedEvenSum != Long.MIN_VALUE && childOddSum != Long.MIN_VALUE) {
            tempNextOdd =
                max(tempNextOdd, childrenCombinedEvenSum + childOddSum) // even + odd = odd
        }
        if (childrenCombinedOddSum != Long.MIN_VALUE && childEvenSum != Long.MIN_VALUE) {
            tempNextOdd =
                max(tempNextOdd, childrenCombinedOddSum + childEvenSum) // odd + even = odd
        }

        childrenCombinedEvenSum = tempNextEven
        childrenCombinedOddSum = tempNextOdd
    }

    var resSubtreeEvenFlips = Long.MIN_VALUE
    var resSubtreeOddFlips = Long.MIN_VALUE

    val valUNormal = nums[u].toLong()
    val valUXorK = (nums[u].toLong() xor kValue.toLong())

    // Case 1: Node u is NOT flipped (contributes 0 to flip count for its own state)
    // To get EVEN total flips in u's subtree: children must contribute EVEN flips
    if (childrenCombinedEvenSum != Long.MIN_VALUE) {
        resSubtreeEvenFlips = max(resSubtreeEvenFlips, valUNormal + childrenCombinedEvenSum)
    }
    // To get ODD total flips in u's subtree: children must contribute ODD flips
    if (childrenCombinedOddSum != Long.MIN_VALUE) {
        resSubtreeOddFlips = max(resSubtreeOddFlips, valUNormal + childrenCombinedOddSum)
    }

    // Case 2: Node u IS flipped (contributes 1 to flip count for its own state)
    // To get EVEN total flips in u's subtree: children must contribute ODD flips (1 + odd = even)
    if (childrenCombinedOddSum != Long.MIN_VALUE) {
        resSubtreeEvenFlips = max(resSubtreeEvenFlips, valUXorK + childrenCombinedOddSum)
    }
    // To get ODD total flips in u's subtree: children must contribute EVEN flips (1 + even = odd)
    if (childrenCombinedEvenSum != Long.MIN_VALUE) {
        resSubtreeOddFlips = max(resSubtreeOddFlips, valUXorK + childrenCombinedEvenSum)
    }

    return Pair(resSubtreeEvenFlips, resSubtreeOddFlips)
}

fun maximumValueSum(edges: Array<IntArray>, k: Int, values: IntArray): Long {
    val n = nums.size
    adj = Array(n) { ArrayList() }
    nums = values
    kValue = k

    for (edge in edges) {
        adj[edge[0]].add(edge[1])
        adj[edge[1]].add(edge[0])
    }

    if (n == 0) return 0L

    // The root can be any node, e.g., 0. Parent of root is -1 (or any non-node index).
    val resultPair = dfs(0, -1)
    return resultPair.first // We need an even number of flips in the whole tree
}