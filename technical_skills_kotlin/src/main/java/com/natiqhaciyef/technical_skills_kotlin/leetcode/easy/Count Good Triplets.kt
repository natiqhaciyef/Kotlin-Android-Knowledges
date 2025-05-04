package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

import kotlin.math.abs

fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    // edge case - if list empty or size less than 3
    if (arr.size < 3) return 0

    // create loop with arr.size-3
    // check conditions
    // count all matched elements (create set for handle this)
    var count = 0
    var i = 0
    var j: Int
    var k: Int

    while (i < arr.size - 2) {
        j = i + 1

        while (j < arr.size - 1) {
            k = j + 1

            while (k < arr.size) {
                if (condition(arr[i], arr[j], a)
                    && condition(arr[j], arr[k], b)
                    && condition(arr[i], arr[k], c)
                )
                    count++

                k++
            }
            j++
        }
        i++
    }

    return count
}


fun condition(element1: Int, element2: Int, expected: Int): Boolean{
    return abs((element1 - element2)) <= expected
}