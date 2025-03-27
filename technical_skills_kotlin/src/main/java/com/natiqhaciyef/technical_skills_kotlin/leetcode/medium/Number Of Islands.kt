package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    fun dfs(r: Int, c: Int) {
        // Boundary check and ensure we are on land
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return

        grid[r][c] = '0' // Mark as visited
        // Visit all 4 adjacent cells
        dfs(r + 1, c) // Down
        dfs(r - 1, c) // Up
        dfs(r, c + 1) // Right
        dfs(r, c - 1) // Left
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                count++ // Found a new island
                dfs(r, c) // Mark the entire island
            }
        }
    }

    return count
}
