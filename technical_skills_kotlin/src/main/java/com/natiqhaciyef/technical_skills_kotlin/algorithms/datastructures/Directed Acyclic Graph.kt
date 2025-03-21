package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures

// Edge list
val edgeListGraph = arrayListOf(
    arrayOf(0, 2),
    arrayOf(2, 1),
    arrayOf(2, 3),
    arrayOf(1, 3)
)

// Adjacent list
val adjacentListGraph = arrayListOf(
    arrayOf(2), // represents 0
    arrayOf(2, 3), // represents 1
    arrayOf(0, 1, 3),   // represents 2
    arrayOf(1, 2)   // represents 3
)

// Adjacent matrix
val adjacentMatrixGraph = arrayListOf(
    arrayOf(0, 0, 1, 0), // represents 0
    arrayOf(0, 0, 1, 1), // represents 1
    arrayOf(1, 1, 0, 1), // represents 2
    arrayOf(0, 1, 1, 0), // represents 3
)

class UndirectedGraph {
    private var numberOfNodes = 0
    private var adjacentList = mutableMapOf<Int, ArrayList<Int>>()


    fun addVertex(value: Int) {
        adjacentList[value] = arrayListOf()
        numberOfNodes += 1
    }

    fun addEdge(value1: Int, value2: Int) {
        val directions1 = adjacentList[value1] ?: return
        val directions2 = adjacentList[value2] ?: return

        // connection
        directions2.add(value1)
        directions1.add(value2)

        adjacentList[value1] = directions1
        adjacentList[value2] = directions2
    }

    fun removeVertex(value: Int){
        val connections = adjacentList[value] ?: return

        for (i in connections){
            val direction = adjacentList[i] ?: continue
            direction.remove(value)
            adjacentList[i] = direction
        }

        adjacentList.remove(value)
    }

    fun removeEdge(value1: Int, value2: Int){
        val directions1 = adjacentList[value1] ?: return
        val directions2 = adjacentList[value2] ?: return

        directions2.remove(value1)
        directions1.remove(value2)

        adjacentList[value1] = directions1
        adjacentList[value2] = directions2
    }

    fun printList() {
        adjacentList.forEach {
            println("${it.key} --> ${it.value}")
        }
    }
}

fun main() {
    val undirectedGraph = UndirectedGraph()
    undirectedGraph.addVertex(1)
    undirectedGraph.addVertex(8)
    undirectedGraph.addVertex(4)
    undirectedGraph.addVertex(14)
    undirectedGraph.addVertex(6)

    undirectedGraph.addEdge(1, 8)
    undirectedGraph.addEdge(1, 14)
    undirectedGraph.addEdge(8, 4)
    undirectedGraph.addEdge(8, 14)
    undirectedGraph.addEdge(4, 6)

    undirectedGraph.removeVertex(1)

    undirectedGraph.printList()
}