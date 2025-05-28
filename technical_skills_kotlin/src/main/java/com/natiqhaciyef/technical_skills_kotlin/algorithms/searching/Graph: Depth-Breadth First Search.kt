package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

import java.util.LinkedList
import java.util.Queue


// Undirected and Directed graph (for both)
fun bfsGraph(graph: Map<Int, List<Int>>, start: Int) {
    val visited = mutableSetOf<Int>()
    val queue: Queue<Int> = LinkedList()

    queue.add(start)
    visited.add(start)

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        val neighbours = graph[node] ?: listOf()

        for (nei in neighbours) {
            if (nei !in visited) {
                queue.add(nei)
                visited.add(nei)
            }
        }
    }
}



// Undirected and directed graph (for both)
fun dfsGraph(
    graph: Map<Int, List<Int>>,
    node: Int,
    visited: MutableSet<Int> = mutableSetOf()
) {
    if (node in visited) return

    visited.add(node)

    val neighbors = graph[node] ?: listOf()
    for (nei in neighbors){
        dfsGraph(graph, nei, visited)
    }
}