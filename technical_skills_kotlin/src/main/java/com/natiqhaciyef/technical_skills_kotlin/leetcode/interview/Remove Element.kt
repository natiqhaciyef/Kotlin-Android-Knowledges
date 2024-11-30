package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview


fun removeElement(nums: IntArray, element: Int): Int {
    for (current in nums.size - 1 downTo 1) {
        if (nums[current] != element) {
            for (next in current - 1 downTo 0) {
                if (nums[next] == element) {
                    nums[next] = nums[current]
                    nums[current] = element
                }
            }
        }
    }

//    print("[")
//    var isFirst = true
//
//    for (index in nums.indices) {
////        if (nums[index] != element) {
//        if (index == 0 || isFirst) {
//            print("${nums[index]}")
//            isFirst = false
//        } else {
//            print(",${nums[index]}")
////            }
//        }
//    }
//    print("]")
//    println()

    return nums.count { it != element }
}


fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    val nums2 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    println(removeElement(nums2, 2))
}