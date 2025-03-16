package com.natiqhaciyef.technical_skills_kotlin.prep.questions.array

fun findTheFirstRepeatedNumber(nums: IntArray): Int {
    val map = mutableMapOf<Int, Boolean>()

    for (num in nums) {
        if (map[num] == true) {
            return num
        } else {
            map[num] = true
        }
    }
    return -1
}


fun main() {
    val arr1 = intArrayOf(1, 3, 4, 1, 5, 7)
    val arr2 = intArrayOf(41, 8, 6, 0, 12, 40, 40)
    val arr3 = intArrayOf(41, 8, 6, 0)

    println(findTheFirstRepeatedNumber(arr1))
    println(findTheFirstRepeatedNumber(arr2))
    println(findTheFirstRepeatedNumber(arr3))
}