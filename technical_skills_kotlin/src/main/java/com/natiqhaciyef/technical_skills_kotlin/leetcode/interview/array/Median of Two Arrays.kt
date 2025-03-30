package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.array

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val list = mutableListOf<Int>()

    var first = 0
    var second = 0

    while(first < nums1.size && second < nums2.size){
        when {
            nums1[first] > nums2[second] -> {
                list.add(nums2[second])
                second +=1
            }

            else -> {
                list.add(nums1[first])
                first +=1
            }
        }
    }

    while(first < nums1.size){
        list.add(nums1[first])
        first += 1
    }

    while(second < nums2.size){
        list.add(nums2[second])
        second += 1
    }

    return if (list.size % 2 == 0)
        (list[list.size/2].toDouble() + list[list.size/2 -1].toDouble())/2
    else
        list[list.size/2].toDouble()

}