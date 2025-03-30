package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph

fun hasCycle(graph: Map<Int, List<Int>>): Boolean {
    val nodeState = mutableMapOf<Int, Int>()  // Stores states: 0 (Not Visited), 1 (Visiting), 2 (Visited)

    // Initialize all nodes to "Not Visited" (0)
    for (node in graph.keys) {
        nodeState[node] = 0
    }

    fun dfs(node: Int): Boolean {
        if (nodeState[node] == 1) return true   // Cycle detected
        if (nodeState[node] == 2) return false  // Already processed, no cycle

        nodeState[node] = 1 // Mark as visiting

        for (neighbor in graph[node] ?: emptyList()) {
            if (dfs(neighbor)) return true
        }

        nodeState[node] = 2 // Mark as fully processed
        return false
    }

    for (node in graph.keys) {
        if (nodeState[node] == 0 && dfs(node)) return true
    }

    return false
}

fun main() {
    val graphWithCycle = mapOf(
        0 to listOf(1),
        1 to listOf(2),
        2 to listOf(0)  // Cycle here: 0 → 1 → 2 → 0
    )

    val graphWithoutCycle = mapOf(
        0 to listOf(1),
        1 to listOf(2),
        2 to listOf(3)
    )

    println(hasCycle(graphWithCycle)) // Output: true
    println(hasCycle(graphWithoutCycle)) // Output: false
}