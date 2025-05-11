package com.natiqhaciyef.technical_skills_kotlin.algorithms.special

fun maxOverlap(intervals: List<Pair<Int, Int>>): Int {
    val events = mutableListOf<Pair<Int, Int>>()  // (time, +1/-1)

    for ((start, end) in intervals) {
        events.add(start to 1)  // start of interval
        events.add(end to -1)   // end of interval
    }

    // Sort by time, break ties: +1 before -1
    events.sortWith(compareBy({ it.first }, { -it.second }))

    var maxCount = 0
    var current = 0

    for ((_, value) in events) {
        current += value
        maxCount = maxOf(maxCount, current)
    }

    return maxCount
}
