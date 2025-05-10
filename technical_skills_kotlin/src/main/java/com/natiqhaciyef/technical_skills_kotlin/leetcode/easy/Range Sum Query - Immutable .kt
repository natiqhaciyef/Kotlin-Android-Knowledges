package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

class NumArray(
    val nums: IntArray
) {

    // if we look again topics
    // there was prefix sum
    private val prefixSum = IntArray(nums.size+1)

    init{
        var sum = 0
        for(i in nums.indices){
            sum += nums[i]
            prefixSum[i+1] = sum
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        // Topic: Array, Design, Prefix Sum

        // we should subtract left from right index of prefix sum
        return prefixSum[right+1] - prefixSum[left]
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */