package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var writeIndex = 1 // Points to the position where the next unique number will go

    // 1,3,4,4,5
    for (readIndex in 1 until nums.size) {
        if (nums[readIndex] != nums[readIndex - 1]) {   //3 != 1, 3 != 4, 4 != 4, 5 != 4
            nums[writeIndex] = nums[readIndex]  // 3 = 3, 4 = 4, -, 5
            writeIndex++    //2, 3, -, 4
        }
    }

    return writeIndex
}