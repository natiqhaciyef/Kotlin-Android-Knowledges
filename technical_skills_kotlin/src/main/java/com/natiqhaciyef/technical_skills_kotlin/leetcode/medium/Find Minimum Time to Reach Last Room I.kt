package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium



// No specific import for PriorityQueue is needed if using the fully qualified name.
// No specific import for max is needed if using the fully qualified name.

/**
 * Represents the state of a cell in Dijkstra's algorithm execution.
 * @property time The earliest known arrival time at this cell.
 * @property row The row index of the cell.
 * @property col The column index of the cell.
 */
private data class CellState(val time: Long, val row: Int, val col: Int) : Comparable<CellState> {
    /**
     * Compares this CellState with another based on time.
     * This is essential for the PriorityQueue to always extract the cell
     * with the minimum arrival time first.
     */
    override fun compareTo(other: CellState): Int = this.time.compareTo(other.time)
}

/**
 * Calculates the minimum time to reach the room (n-1, m-1) from (0,0)
 * in a grid with time-based movement constraints.
 *
 * @param moveTime A 2D array where moveTime[i][j] represents the minimum
 * time in seconds when you can start moving to room (i,j).
 * @return The minimum time in seconds to reach room (n-1, m-1).
 * Returns -1 if the destination is somehow unreachable (though problem
 * constraints usually guarantee reachability).
 */
fun minTimeToReach(moveTime: Array<IntArray>): Int {
    val n = moveTime.size
    val m = moveTime[0].size

    // minArrivalTimes[r][c] stores the minimum arrival time at cell (r,c).
    // Initialized to Long.MAX_VALUE to represent infinity.
    val minArrivalTimes = Array(n) { LongArray(m) { Long.MAX_VALUE } }

    // Start at room (0,0) at time t=0.
    minArrivalTimes[0][0] = 0L

    // PriorityQueue stores CellState objects, ordered by the smallest time.
    // Use the fully qualified name to avoid import ambiguity.
    val pq = java.util.PriorityQueue<CellState>()
    pq.add(CellState(0L, 0, 0))

    // Deltas for moving to adjacent cells: up, down, left, right.
    val dr = intArrayOf(-1, 1, 0, 0)
    val dc = intArrayOf(0, 0, -1, 1)

    while (pq.isNotEmpty()) { // pq.isNotEmpty() is idiomatic
        val currentCell = pq.poll()
        val currentArrivalTimeAtRC = currentCell.time
        val r = currentCell.row
        val c = currentCell.col

        // If we've already found a shorter path to (r,c) and processed it, skip.
        if (currentArrivalTimeAtRC > minArrivalTimes[r][c]) {
            continue
        }

        // If the destination (n-1, m-1) is reached.
        if (r == n - 1 && c == m - 1) {
            return currentArrivalTimeAtRC.toInt()
        }

        // Explore neighbors of the current cell (r,c).
        for (i in 0..3) {
            val nr = r + dr[i] // next_row
            val nc = c + dc[i] // next_col

            // Check if the neighbor is within grid boundaries.
            if (nr in 0 until n && nc in 0 until m) {
                // Use kotlin.math.max for robust compatibility.
                val departureTime =
                    kotlin.math.max(currentArrivalTimeAtRC, moveTime[nr][nc].toLong())

                val arrivalTimeAtNeighbor = departureTime + 1L

                if (arrivalTimeAtNeighbor < minArrivalTimes[nr][nc]) {
                    minArrivalTimes[nr][nc] = arrivalTimeAtNeighbor
                    pq.add(CellState(arrivalTimeAtNeighbor, nr, nc))
                }
            }
        }
    }

    // This part should not be reached if the destination is always reachable.
    return -1
}