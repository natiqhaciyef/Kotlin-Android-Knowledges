package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

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

    return nums.count { it != element }
}
