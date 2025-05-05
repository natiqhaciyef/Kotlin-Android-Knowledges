package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

private val cache = mutableListOf<Int>()
fun jump(nums: IntArray): Int {
    // Topics: Array, Dynamic Programming, Greedy
    // j <= nums[i]
    // n = nums.size
    // i+j < n
    var jump = 0
    var farthest = 0
    var currentEnd = 0


    // No used dynamic programming but still greedy methods
    for(i in 0 until nums.size-1){

        // BFS logic
        farthest = maxOf(i + nums[i], farthest)
        if(i == currentEnd){
            jump += 1
            currentEnd = farthest
        }
    }

    return jump
}