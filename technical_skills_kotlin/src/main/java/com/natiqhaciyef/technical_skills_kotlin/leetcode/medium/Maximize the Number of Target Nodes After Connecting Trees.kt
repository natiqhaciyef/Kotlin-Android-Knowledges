package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max


// TODO: USED GEMINI 2.5 PRO VERSION FOR SOLUTION
fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
    val n = edges1.size + 1
    val m = edges2.size + 1

    // Helper function for BFS to calculate distances from a source node
    // It can be nested inside maxTargetNodes or be a private top-level/companion object function
    fun bfs(numNodes: Int, startNode: Int, adj: Array<MutableList<Int>>): IntArray {
        val distances = IntArray(numNodes) { -1 } // -1 for unreachable

        // Basic check for startNode, though loops calling bfs should provide valid startNode
        if (startNode < 0 || startNode >= numNodes && distances.isNotEmpty()) {
            return distances // Should not be hit with valid inputs given n,m >=2
        }

        // If numNodes is 0, adj might be empty, distances could be empty.
        // However, n, m >= 2, so numNodes will be >= 2.
        // If startNode is valid and numNodes > 0
        if (numNodes > 0 && startNode < numNodes) {
            distances[startNode] = 0
        } else { // Should not happen with n, m >= 2
            return distances
        }


        val queue: Queue<Int> = LinkedList()
        queue.offer(startNode)

        while (queue.isNotEmpty()) {
            val u = queue.poll()
            if (u < adj.size) { // Ensure u is a valid index for adj
                for (v in adj[u]) {
                    if (v < distances.size && distances[v] == -1) { // Ensure v is a valid index
                        distances[v] = distances[u] + 1
                        queue.offer(v)
                    }
                }
            }
        }
        return distances
    }

    // Adjacency lists for tree1 and tree2
    val adj1 = Array(n) { mutableListOf<Int>() }
    for (edge in edges1) {
        // Assuming valid edge labels within [0, n-1]
        if (edge[0] < n && edge[1] < n && edge[0] >= 0 && edge[1] >= 0) {
            adj1[edge[0]].add(edge[1])
            adj1[edge[1]].add(edge[0])
        }
    }

    val adj2 = Array(m) { mutableListOf<Int>() }
    for (edge in edges2) {
        // Assuming valid edge labels within [0, m-1]
        if (edge[0] < m && edge[1] < m && edge[0] >= 0 && edge[1] >= 0) {
            adj2[edge[0]].add(edge[1])
            adj2[edge[1]].add(edge[0])
        }
    }

    // 1. Compute all-pairs shortest paths for tree1 (dist1[i][j])
    val dist1 = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        dist1[i] = bfs(n, i, adj1)
    }

    // 2. Compute all-pairs shortest paths for tree2 (dist2[i][j])
    val dist2 = Array(m) { IntArray(m) }
    // m >= 2 from constraints, so m > 0 is true
    for (i in 0 until m) {
        dist2[i] = bfs(m, i, adj2)
    }

    // 3. Precompute countT1Direct[s_query]: number of nodes in tree1 <= k distance from s_query
    val countT1Direct = IntArray(n)
    for (sQuery in 0 until n) {
        var count = 0
        for (x1 in 0 until n) {
            if (dist1[sQuery][x1] != -1 && dist1[sQuery][x1] <= k) {
                count++
            }
        }
        countT1Direct[sQuery] = count
    }

    // 4. Precompute countInT2WithinDist[node_in_T2][d_limit]
    //    Number of nodes v in tree2 such that dist2[node_in_T2][v] <= d_limit
    val countInT2WithinDist = Array(m) { IntArray(k + 1) }
    // m >= 2 from constraints
    for (uNode2 in 0 until m) {
        val nodesAtExactDist = IntArray(m)
        for (vNode2 in 0 until m) {
            if (dist2[uNode2][vNode2] != -1 && dist2[uNode2][vNode2] < m) {
                nodesAtExactDist[dist2[uNode2][vNode2]]++
            }
        }

        var cumulativeCount = 0
        for (dLimit in 0..k) {
            if (dLimit < m) {
                cumulativeCount += nodesAtExactDist.getOrElse(dLimit) { 0 }
            }
            countInT2WithinDist[uNode2][dLimit] = cumulativeCount
        }
    }

    // 5. Precompute maxReachableForDistLimitInT2[d_limit]
    //    Max over c2_node (countInT2WithinDist[c2_node][d_limit])
    val maxReachableForDistLimitInT2 = IntArray(k + 1)
    // m >= 2 from constraints
    for (dLimit in 0..k) {
        var currentMax = 0
        for (uNode2 in 0 until m) {
            currentMax = max(currentMax, countInT2WithinDist[uNode2][dLimit])
        }
        maxReachableForDistLimitInT2[dLimit] = currentMax
    }

    // 6. Calculate final answer
    val answer = IntArray(n)
    for (sQuery in 0 until n) {
        val targetsFixedFromT1 = countT1Direct[sQuery]
        var maxAdditionalTargetsFromT2 = 0

        // m >= 2 from constraints
        for (c1NodeInT1 in 0 until n) {
            val distSToC1 = dist1[sQuery][c1NodeInT1]

            if (distSToC1 != -1) {
                val remKForT2 = k - (distSToC1 + 1)
                if (remKForT2 >= 0) {
                    maxAdditionalTargetsFromT2 = max(maxAdditionalTargetsFromT2, maxReachableForDistLimitInT2[remKForT2])
                }
            }
        }
        answer[sQuery] = targetsFixedFromT1 + maxAdditionalTargetsFromT2
    }
    return answer
}