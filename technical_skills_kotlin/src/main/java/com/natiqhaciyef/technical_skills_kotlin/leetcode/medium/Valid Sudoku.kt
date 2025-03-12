package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = Array(9) { HashSet<Char>() }
    val cols = Array(9) { HashSet<Char>() }
    val boxes = Array(9) { HashSet<Char>() }

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            val num = board[i][j]
            if (num == '.') continue

            val boxIndex = (i / 3) * 3 + (j / 3)

            if (num in rows[i] || num in cols[j] || num in boxes[boxIndex]) {
                return false
            }

            rows[i].add(num)
            cols[j].add(num)
            boxes[boxIndex].add(num)
        }
    }
    return true
}

fun main() {
    val test = arrayOf(
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
    )

    println(isValidSudoku(test))
}