package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val holder = mutableListOf<Int>()

    for(num in nums1){
        if(map[num] == null)
            map[num] = 1
        else
            map[num] = map[num]!! + 1
    }

    for (num in nums2){
        if(map[num] != null && map[num] != 0){
            holder.add(num)
            map[num] = map[num]!! - 1
        }
    }

    return holder.toIntArray()
}