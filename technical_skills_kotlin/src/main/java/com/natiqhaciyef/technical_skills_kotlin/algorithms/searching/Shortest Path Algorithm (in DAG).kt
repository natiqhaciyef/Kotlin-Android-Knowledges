package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

import java.util.*

data class Edge(val vertex: Int, val weight: Int)

fun topologicalSort(graph: Array<MutableList<Edge>>, numVertices: Int): List<Int> {
    val inDegree = IntArray(numVertices)
    val stack = Stack<Int>()
    val topoOrder = mutableListOf<Int>()

    // Compute in-degree for each vertex
    for (u in 0 until numVertices) {
        for (edge in graph[u]) {
            inDegree[edge.vertex]++
        }
    }

    // Initialize stack with vertices having zero in-degree
    for (u in 0 until numVertices) {
        if (inDegree[u] == 0) {
            stack.push(u)
        }
    }

    // Process vertices in topological order
    while (stack.isNotEmpty()) {
        val u = stack.pop()
        topoOrder.add(u)

        // Reduce in-degree of neighbors
        for (edge in graph[u]) {
            inDegree[edge.vertex]--
            if (inDegree[edge.vertex] == 0) {
                stack.push(edge.vertex)
            }
        }
    }

    return topoOrder
}

fun shortestPathDAG(graph: Array<MutableList<Edge>>, numVertices: Int, source: Int): IntArray {
    val topoOrder = topologicalSort(graph, numVertices)
    val dist = IntArray(numVertices) { Int.MAX_VALUE }
    dist[source] = 0

    // Process vertices in topological order
    for (u in topoOrder) {
        if (dist[u] != Int.MAX_VALUE) { // Ignore unreachable vertices
            for (edge in graph[u]) {
                if (dist[edge.vertex] > dist[u] + edge.weight) {
                    dist[edge.vertex] = dist[u] + edge.weight
                }
            }
        }
    }

    return dist
}

fun main() {
    val numVertices = 6
    val graph = Array(numVertices) { mutableListOf<Edge>() }

    // Add edges (vertex, weight)
    graph[0].add(Edge(1, 5))
    graph[0].add(Edge(2, 3))
    graph[1].add(Edge(3, 6))
    graph[1].add(Edge(2, 2))
    graph[2].add(Edge(4, 4))
    graph[2].add(Edge(5, 2))
    graph[3].add(Edge(5, 1))
    graph[4].add(Edge(5, 3))

    val source = 0
    val dist = shortestPathDAG(graph, numVertices, source)

    println("Shortest paths from vertex $source:")
    for (i in dist.indices) {
        if (dist[i] == Int.MAX_VALUE) {
            println("Vertex $i is unreachable")
        } else {
            println("Vertex $i: ${dist[i]}")
        }
    }
}
