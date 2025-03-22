package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

data class BellmanEdge(val source: Int, val destination: Int, val weight: Int)

class BellmanGraph(val vertices: Int, val edges: List<BellmanEdge>) {

    fun bellmanFord(start: Int): IntArray? {
        val distances = IntArray(vertices) { Int.MAX_VALUE }
        distances[start] = 0

        // Step 1: Relax all edges |V| - 1 times
        for (i in 1 until vertices) {
            for (edge in edges) {
                if (distances[edge.source] != Int.MAX_VALUE &&
                    distances[edge.source] + edge.weight < distances[edge.destination]) {
                    distances[edge.destination] = distances[edge.source] + edge.weight
                }
            }
        }

        // Step 2: Detect negative weight cycle
        for (edge in edges) {
            if (distances[edge.source] != Int.MAX_VALUE &&
                distances[edge.source] + edge.weight < distances[edge.destination]) {
                println("Graph contains a negative weight cycle!")
                return null
            }
        }

        return distances
    }
}

fun main() {
    val edges = listOf(
        BellmanEdge(0, 1, 4),
        BellmanEdge(0, 2, 5),
        BellmanEdge(1, 2, -3),
        BellmanEdge(2, 3, 4),
        BellmanEdge(3, 1, -6)
    )

    val graph = BellmanGraph(4, edges)
    val distances = graph.bellmanFord(0)

    distances?.let {
        println("Shortest distances from node 0: ${it.joinToString()}")
    }
}
