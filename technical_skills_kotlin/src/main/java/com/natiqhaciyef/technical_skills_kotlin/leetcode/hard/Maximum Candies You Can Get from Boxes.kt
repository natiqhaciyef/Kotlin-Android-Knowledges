package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard


fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {

    // Topics: Array, BFS, Graph
    // DAG - Directed Acyclic Graph
    // Multiple components
    // Collect open boxes
    // Save then opened boxes
    var totalCandies = 0

    val haveKeys = status.indices.filter { status[it] == 1 }.toMutableSet()
    val haveBoxes = initialBoxes.toMutableSet()
    val queue = ArrayDeque<Int>()

    // Start with boxes we can open
    for (box in initialBoxes) {
        if (status[box] == 1) {
            queue.add(box)
        }
    }

    val visited = mutableSetOf<Int>()

    while (queue.isNotEmpty()) {
        val box = queue.removeFirst()
        if (box in visited) continue

        visited.add(box)
        totalCandies += candies[box]

        // Collect keys
        for (key in keys[box]) {
            haveKeys.add(key)
            // If we already have the box for this key, and it was closed, open it
            if (key in haveBoxes && key !in visited) {
                queue.add(key)
            }
        }

        // Collect contained boxes
        for (contained in containedBoxes[box]) {
            haveBoxes.add(contained)
            // If the contained box is open (or we now have a key), process it
            if (status[contained] == 1 || contained in haveKeys) {
                queue.add(contained)
            }
        }
    }

    return totalCandies
}

