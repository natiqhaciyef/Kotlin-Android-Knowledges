package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    // Topic: Array
    // [sliding window technique may be useful]
    // more simple

    var i = 0

    // Time Complexity: worst case O(N-2)
    // Space Complexity: 1
    while(i < arr.size-2){
        if(arr[i] % 2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] % 2 == 1)
            return true

        i+=1
    }

    return false
}