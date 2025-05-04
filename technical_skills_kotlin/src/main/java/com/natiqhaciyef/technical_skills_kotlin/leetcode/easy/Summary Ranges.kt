package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun summaryRanges(nums: IntArray): List<String> {
    if(nums.size == 0) return listOf()
    if(nums.size == 1) return listOf(nums[0].toString())
    val list = mutableListOf<String>()

    var first = nums[0]
    var last = nums[0]
    for(i in 1 until nums.size){
        if(nums[i] != last + 1){
            if(first == last)
                list.add("$first")
            else
                list.add("$first->$last")

            first = nums[i]
        }

        last = nums[i]

        if(i == nums.size-1){
            if(first == last)
                list.add("$first")
            else
                list.add("$first->$last")
        }
    }

    return list
}