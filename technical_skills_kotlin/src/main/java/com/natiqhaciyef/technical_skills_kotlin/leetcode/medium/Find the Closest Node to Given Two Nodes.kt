package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    // for count distances of nodes from node1
    val map1 = mutableMapOf<Int, Int>()
    // for count distances of nodes from node2
    val map2 = mutableMapOf<Int, Int>()


    // from the statement each node only have single direction to another node
    // thats why we don't need to create Map<Int, MutableList<Int>>()
    // because every node has only one neighbour
    val adjMap = mutableMapOf<Int, Int>()

    for(i in edges.indices){
        adjMap[i] = edges[i]
    }

    // tracking distance and set to the map
    fun dfs(node: Int, map: MutableMap<Int, Int>, distance: Int) {
        if (node == -1 || node in map) return

        map[node] = distance
        val next = adjMap.getOrDefault(node, -1)
        dfs(next, map, distance + 1)
    }

    // Compute distances from node1 and node2
    dfs(node1, map1, 0)
    dfs(node2, map2, 0)

    var result = -1
    var minDistance = Int.MAX_VALUE

    for (i in edges.indices) {
        // if i exists in both map
        if (map1.containsKey(i) && map2.containsKey(i)) {

            val maxDist = maxOf(map1[i]!!, map2[i]!!)

            if (maxDist < minDistance) {
                minDistance = maxDist
                result = i
            } else if (maxDist == minDistance && i < result) {
                result = i
            }
        }
    }

    return result
}