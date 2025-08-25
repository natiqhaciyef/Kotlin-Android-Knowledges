package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val m = mat.size
    val n = mat[0].size
    val result = IntArray(m * n)
    var counter = 0

    for (value in 0 until (m + n - 1)) {
        val diagonal = mutableListOf<Int>()

        var row = if (value < n) 0
        else value - n + 1

        var column = if (value < n) value
        else n - 1

        while (row < m && column >= 0) {
            diagonal.add(mat[row][column])
            row += 1
            column -= 1
        }

        if (value % 2 == 0) {
            diagonal.reverse()
        }

        for (num in diagonal) {
            result[counter] = num
            counter += 1
        }
    }

    return result
}


fun main() {
    val mat1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    findDiagonalOrder(mat1)
}
