package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

import java.util.PriorityQueue

data class DijkstraEdge(val destination: Int, val weight: Int)
data class DijkstraNode(val vertex: Int, val distance: Int) : Comparable<DijkstraNode> {
    override fun compareTo(other: DijkstraNode): Int = this.distance - other.distance
}

class DijkstraGraph(val vertices: Int) {
    private val adjacencyList = Array(vertices) { mutableListOf<DijkstraEdge>() }

    fun addEdge(source: Int, destination: Int, weight: Int) {
        adjacencyList[source].add(DijkstraEdge(destination, weight))
        adjacencyList[destination].add(DijkstraEdge(source, weight)) // For undirected graph
    }

    fun dijkstra(start: Int): IntArray {
        val distances = IntArray(vertices) { Int.MAX_VALUE }
        val priorityQueue = PriorityQueue<DijkstraNode>()
        distances[start] = 0
        priorityQueue.add(DijkstraNode(start, 0))

        while (priorityQueue.isNotEmpty()) {
            val currentNode = priorityQueue.poll()
            val currentVertex = currentNode.vertex

            for (edge in adjacencyList[currentVertex]) {
                val newDistance = distances[currentVertex] + edge.weight
                if (newDistance < distances[edge.destination]) {
                    distances[edge.destination] = newDistance
                    priorityQueue.add(DijkstraNode(edge.destination, newDistance))
                }
            }
        }

        return distances
    }
}

fun main() {
    val graph = DijkstraGraph(6)
    graph.addEdge(0, 1, 4)
    graph.addEdge(0, 2, 4)
    graph.addEdge(1, 2, 2)
    graph.addEdge(1, 3, 5)
    graph.addEdge(2, 3, 1)
    graph.addEdge(3, 4, 3)
    graph.addEdge(4, 5, 1)

    val distances = graph.dijkstra(0)

    println("Shortest distances from node 0: ${distances.joinToString()}")
}
