package com.natiqhaciyef.technical_skills_kotlin.hackerrank.medium

import kotlin.math.abs
import kotlin.math.atan


// Not solved yet


val changes = arrayOf(
    arrayOf(arrayOf(8, 3, 4), arrayOf(1, 5, 9), arrayOf(6, 7, 2)),
    arrayOf(arrayOf(4, 3, 8), arrayOf(9, 5, 1), arrayOf(2, 7, 6)),

    arrayOf(arrayOf(8, 1, 6), arrayOf(3, 5, 7), arrayOf(4, 9, 2)),
    arrayOf(arrayOf(6, 1, 8), arrayOf(7, 5, 3), arrayOf(2, 9, 4)),

    arrayOf(arrayOf(4, 9, 2), arrayOf(3, 5, 7), arrayOf(8, 1, 6)),
    arrayOf(arrayOf(2, 9, 4), arrayOf(7, 5, 3), arrayOf(6, 1, 8)),

    arrayOf(arrayOf(6, 7, 2), arrayOf(1, 5, 9), arrayOf(8, 3, 4)),
    arrayOf(arrayOf(2, 7, 6), arrayOf(9, 5, 1), arrayOf(4, 3, 8)),
)

fun formingMagicSquare(s: Array<Array<Int>>): Int {
    var minCost = Int.MAX_VALUE

    for (magicSquare in changes) {
        var cost = 0
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                cost += Math.abs(s[i][j] - magicSquare[i][j])
            }
        }
        minCost = minOf(minCost, cost)
    }

    return minCost
}
