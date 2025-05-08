package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


private val list = mutableListOf<Int>()

fun minTimeToReachBruteForce(moveTime: Array<IntArray>): Int {
    backtrackHorizontal(moveTime, 0, 0, 1, moveTime[0][1], moveTime[0][0])
    backtrackVertical(moveTime, 0, 0, 1, moveTime[1][0], moveTime[0][0])
    return list.min()
}

fun backtrackHorizontal(
    moveTime: Array<IntArray>,
    v: Int,
    h: Int,
    add: Int,
    value: Int,
    prev: Int
) {
    // first horizontal
    // then vertical
    var result = value
    if (h < moveTime[v].size - 1) {
        val calc = moveTime[v][h + 1] - value
        result += if (calc < 0) add else calc + add
        if (result < 0) result = 0

        println("calc = $result")
        println("h => ${h + 1}")
        println("v => $v")
        println("---------h----------")
        backtrackHorizontal(moveTime, v, h + 1, if (add == 1) 2 else 1, result, moveTime[v][h + 1])

        if (v < moveTime.size - 1)
            backtrackHorizontal(
                moveTime,
                v + 1,
                h,
                if (add == 1) 2 else 1,
                result,
                moveTime[v + 1][h]
            )
    }

    if (h == moveTime[v].size - 1 && v == moveTime.size - 1) {
        println("Added = $result")
        list.add(result)
    }
}

fun backtrackVertical(moveTime: Array<IntArray>, v: Int, h: Int, add: Int, value: Int, prev: Int) {
    // first vertical
    // then horizontal
    var result = value

    if (v < moveTime.size - 1) {
        val calc = moveTime[v + 1][h] - value
        result += if (calc < 0) add else calc + add
        if (result < 0) result = 0

        println("calc = $result")
        println("h => $h")
        println("v => ${v + 1}")
        println("---------v----------")
        backtrackVertical(moveTime, v + 1, h, if (add == 1) 2 else 1, result, moveTime[v + 1][h])

        if (h < moveTime[v].size - 1)
            backtrackVertical(
                moveTime,
                v,
                h + 1,
                if (add == 1) 2 else 1,
                result,
                moveTime[v][h + 1]
            )
    }

    if (h == moveTime[v].size - 1 && v == moveTime.size - 1) {
        println("Added = $result")
        list.add(result)
    }
}


// State for Dijkstra's algorithm:
// time: current time of arrival at (r, c)
// r, c: coordinates of the current room
// isNextMoveFromThisCell1SecCost: boolean flag.
//   true: the next move *departing from* (r,c) will cost 1 second.
//   false: the next move *departing from* (r,c) will cost 2 seconds.
data class State(
    val time: Int,
    val r: Int,
    val c: Int,
    val isNextMoveFromThisCell1SecCost: Boolean
) : Comparable<State> {
    override fun compareTo(other: State): Int {
        // PriorityQueue is a min-heap, so sort by time.
        return this.time.compareTo(other.time)
    }
}

fun minTimeToReach2(moveTime: Array<IntArray>): Int {
    val n = moveTime.size
    val m = moveTime[0].size

    // Special case: If the start is the destination.
    if (n == 1 && m == 1) {
        return 0
    }

    // dist[r][c][0]: Min time to arrive at (r,c) such that the next move *from* (r,c) costs 1 second.
    // dist[r][c][1]: Min time to arrive at (r,c) such that the next move *from* (r,c) costs 2 seconds.
    // Initialize distances to infinity.
    val dist = Array(n) { Array(m) { IntArray(2) { Int.MAX_VALUE } } }
    val pq = java.util.PriorityQueue<State>()

    // Initial state:
    // Start at room (0,0) at time t=0.
    // The first move (1st step in any path) costs 1 second.
    dist[0][0][0] = 0
    pq.add(State(0, 0, 0, true)) // true: next move from (0,0) costs 1 sec.

    // Movement directions: up, down, left, right
    val dr = intArrayOf(-1, 1, 0, 0)
    val dc = intArrayOf(0, 0, -1, 1)

    while (pq.isNotEmpty()) {
        val currentState = pq.poll()
        val currentTime = currentState.time
        val r = currentState.r
        val c = currentState.c
        val isNextMoveFromCurrent1Sec = currentState.isNextMoveFromThisCell1SecCost

        val distIndexForCurrent = if (isNextMoveFromCurrent1Sec) 0 else 1

        if (currentTime > dist[r][c][distIndexForCurrent]) {
            continue
        }

        val costOfMoveFromCurrent = if (isNextMoveFromCurrent1Sec) 1 else 2
        val isNextMoveFromNeighbor1Sec = !isNextMoveFromCurrent1Sec

        for (i in 0..3) { // Iterate over all 4 possible directions
            val nr = r + dr[i] // Neighbor row
            val nc = c + dc[i] // Neighbor column

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) { // Check bounds
                val earliestCanStartMovingToNeighbor = moveTime[nr][nc]
                val actualDepartureTime = maxOf(currentTime, earliestCanStartMovingToNeighbor)
                val timeArriveNeighbor = actualDepartureTime + costOfMoveFromCurrent

                val distIndexForNeighborState = if (isNextMoveFromNeighbor1Sec) 0 else 1

                if (timeArriveNeighbor < dist[nr][nc][distIndexForNeighborState]) {
                    dist[nr][nc][distIndexForNeighborState] = timeArriveNeighbor
                    pq.add(State(timeArriveNeighbor, nr, nc, isNextMoveFromNeighbor1Sec))
                }
            }
        }
    }

    val result = minOf(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1])

    // If Int.MAX_VALUE, target is unreachable. Problem examples imply reachability.
    // Returning -1 is a common convention for unreachability if not specified otherwise.
    return if (result == Int.MAX_VALUE) -1 else result
}