package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph

import java.util.*

fun shortestPath(graph: Map<Int, List<Int>>, start: Int, end: Int): List<Int> {
    val queue: Queue<Int> = LinkedList()
    val visited = mutableSetOf<Int>()
    val parent = mutableMapOf<Int, Int>()

    queue.add(start)
    visited.add(start)

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (node == end) break

        for (neighbor in graph[node] ?: emptyList()) {
            if (neighbor !in visited) {
                queue.add(neighbor)
                visited.add(neighbor)
                parent[neighbor] = node
            }
        }
    }

    println(queue.toList())
    println(parent)

    // Reconstruct path
    val path = mutableListOf<Int>()
    var curr: Int? = end
    while (curr != null) {
        path.add(0, curr)
        curr = parent[curr]
    }

    return if (path.first() == start) path else emptyList()
}

fun main() {
    val graph = mapOf(
        0 to listOf(1, 2),
        1 to listOf(0, 3, 4),
        2 to listOf(0, 5, 6),
        3 to listOf(1),
        4 to listOf(1, 5),
        5 to listOf(2, 4, 6),
        6 to listOf(2, 5)
    )

    println(shortestPath(graph, 0, 6))  // Output: [0, 2, 6]
}