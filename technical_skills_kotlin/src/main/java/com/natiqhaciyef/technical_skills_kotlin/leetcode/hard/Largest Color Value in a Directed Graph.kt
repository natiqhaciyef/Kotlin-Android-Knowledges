package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard


fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    val n = colors.length

    // index of array is u
    // each u contains possible neighbours in adj[u] as a Mutable List
    val adj = Array(n) { mutableListOf<Int>() }

    // inDegree is a list of detecting cycle. It stores how many edges direct to index v
    // for example first element 0 -> there are 2 different element which 0 directs to them so inDegree[v] = 1
    // if there all index of inDegree are more than 1 it means cycle detected
    val inDegree = IntArray(n)

    // stores each neighbours of u with single mutable list
    for (edge in edges) {
        val u = edge[0]
        val v = edge[1]

        adj[u].add(v)
        inDegree[v] += 1
    }

    var result = -1
    val visited = mutableSetOf<Int>()
    val path = mutableSetOf<Int>()
    val countMatrix = Array(n) { IntArray(26) }

    fun dfsOp(node: Int): Int {
        if (node in path) return -1
        if (node in visited) return 0

        // adding to visited and current path
        path.add(node)

        // finding the current colors index (a => 0, b => 1 .. z => 25)
        // it is useful for storing countMatrix
        val colorIndex = colors[node] - 'a'

        // setting 1 to countMatrix currentIndex because current Node contains some color and we set it as a 1
        countMatrix[node][colorIndex] = 1

        // then neighbours of this node (which we stored in adj in first stage)
        for (neighbour in adj[node]) {
            if (dfsOp(neighbour) == -1)
                return -1

            // we increase value of current neighbour with previous value of it (as stepping vertical or column)
            // it will set the max value of each colors with comparing previous value
            for (c in 0 until 26) {
                val nei =
                    if (c == colorIndex) countMatrix[neighbour][c] + 1 else countMatrix[neighbour][c]

                countMatrix[node][c] = maxOf(countMatrix[node][c], nei)
            }
        }

        // we 've done all actions that's why remove from path is important because it could return -1 if remains
        path.remove(node)
        visited.add(node)
        // it will reflect the most frequent color in current countMatrix
        return countMatrix[node].max()
    }


    for (i in 0 until n) {

        // checking if value returns -1 then stop operation and return -1
        // only this part solved with gpt support
        val value = dfsOp(i)
        if (value == -1) return -1
        result = maxOf(result, value)
    }


    return result
}
fun main() {
    largestPathValue(
        colors = "abaca",
        edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
        )
    )
}