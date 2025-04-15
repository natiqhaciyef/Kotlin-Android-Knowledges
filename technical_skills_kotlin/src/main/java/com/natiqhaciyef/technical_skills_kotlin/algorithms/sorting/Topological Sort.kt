package com.natiqhaciyef.technical_skills_kotlin.algorithms.sorting

class Graph(private val vertices: Int) {
    private val adjList = Array(vertices) { mutableListOf<Int>() }

    fun addEdge(from: Int, to: Int) {
        adjList[from].add(to)
    }

    fun topologicalSort(): List<Int> {
        val visited = BooleanArray(vertices)
        val stack = mutableListOf<Int>()

        fun dfs(v: Int) {
            visited[v] = true
            for (neighbor in adjList[v]) {
                if (!visited[neighbor]) { dfs(neighbor) }
            }
            stack.add(v)
        }

        for (v in 0 until vertices) {
            if (!visited[v]) dfs(v)
        }

        return stack.reversed()
    }
}

fun main() {
    val g = Graph(6)
    g.addEdge(5, 2)
    g.addEdge(5, 0)
    g.addEdge(4, 0)
    g.addEdge(4, 1)
    g.addEdge(2, 3)
    g.addEdge(3, 1)

    val order = g.topologicalSort()
    println("Topological Order: $order")
}
