package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun minSum(nums1: IntArray, nums2: IntArray): Long {
    var sum1 = 0L
    var sum2 = 0L

    var zeroes1 = 0L
    var zeroes2 = 0L

    // find the sum of both arrays & count zeroes
    for(num1 in nums1){
        sum1 += num1

        if(num1 == 0)
            zeroes1 += 1L
    }

    for(num2 in nums2){
        sum2 += num2

        if(num2 == 0)
            zeroes2 += 1L
    }

    // println("sum1 = $sum1")         // 6
    // println("sum2 = $sum2")         // 11
    // println("zeroes1 = $zeroes1")   // 2
    // println("zeroes2 = $zeroes2")   // 1

    var currentSum1 = sum1 + zeroes1
    var currentSum2 = sum2 + zeroes2

    if(zeroes1 == 0L && currentSum2 > sum1){
        return -1L
    }

    if(zeroes2 == 0L && currentSum1 > sum2){
        return -1L
    }

    // find difference between sum
    if(sum1 > sum2){
        val result = sum1 - sum2

        while(currentSum1 < currentSum2){
            currentSum1 += 1L
        }

        return currentSum1

    }else {
        val result = sum2 - sum1

        while(currentSum1 > currentSum2){
            currentSum2 += 1L
        }

        return currentSum2
    }


    return -1L
}