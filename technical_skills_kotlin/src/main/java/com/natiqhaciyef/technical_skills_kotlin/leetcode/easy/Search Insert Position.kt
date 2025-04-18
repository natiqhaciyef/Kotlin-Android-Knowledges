package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun searchInsert(nums: IntArray, target: Int): Int {
    // edge case
    if(nums.isEmpty()) return -1
    if(nums[nums.size-1] < target) return nums.size
    if(nums[0] >= target) return 0

    // we use binary search due to O(log n) time complexity
    // principle is divide & conquer

    // [0, 1, [2], 3, 4, [5], 6, [7], [8], 9, 10]
    // [0, 1, 2, 3, 4, [5], 7, [8], [9], 10, 11]
    // [0, 1, 2, 3, 4, 5, 6, 7]
    var start = 0
    var end = nums.size-1
    var temp = nums.size/2

    while(temp in (start + 1)..<end){
        when {
            nums[temp] > target -> {
                end = temp
                temp = (temp+start+1)/2
            }

            nums[temp] < target -> {
                start = temp
                temp = (start + end)/2
            }

            else -> return temp
        }
    }

    return end
}
