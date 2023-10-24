package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.medium

import kotlin.math.abs

fun maxArea(height: IntArray): Int {
    val result = mutableListOf<Int>()

    for (i in height.indices) {
        for (j in height.indices) {
            if (height[j] >= height[i])
                result.add(height[i] * abs(j-i))
        }
    }

    return result.max()
}

fun maxAreaFast(height: IntArray): Int {
    var max = 0
    var left = 0
    var right = height.size - 1

    while (left < right) {
        max = maxOf(max, minOf(height[left], height[right]) * (right - left))

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return max
}

fun main() {
}