package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val list = nums1.toMutableList()
    list.addAll(nums2.toMutableList())

    list.sort()
    val size = list.size

    return if (size % 2 == 0)
        (list[list.size/2].toDouble() + list[list.size/2 -1].toDouble())/2
    else
        list[list.size/2].toDouble()
}

fun main() {

}