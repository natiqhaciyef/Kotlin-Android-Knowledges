package com.natiqhaciyef.technical_skills_kotlin.algorithms.special

fun kadanesAlgorithm(arr: IntArray): Int {
    var maxSoFar = arr[0]
    var currentMax = arr[0]

    for (i in 1 until arr.size) {
        currentMax = maxOf(arr[i], currentMax + arr[i])
        maxSoFar = maxOf(maxSoFar, currentMax)
    }

    return maxSoFar
}

fun main() {
    val array = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val maxSum = kadanesAlgorithm(array)
    println("Maximum Subarray Sum: $maxSum")
}
