package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun hIndex(citations: IntArray): Int {
    var counter = 0

    val result = mergeSort(citations)
    // println(result.toMutableList())

    for(i in citations.indices){
        if(result[i] >= i+1)
            counter += 1
    }

    return counter
}

private fun mergeSort(nums: IntArray): IntArray{
    if(nums.size <= 1)
        return nums

    val half = nums.size/2

    val left = IntArray(half)
    for(i in 0 until half){
        left[i] = nums[i]
    }

    val right = IntArray(nums.size-half)
    for(i in half until nums.size){
        right[i-half] = nums[i]
    }

    return merge(
        mergeSort(left),
        mergeSort(right)
    )
}

private fun merge(left: IntArray, right: IntArray): IntArray{
    val arr = IntArray(left.size + right.size)
    var i = 0
    var j = 0


    while(i < left.size && j < right.size){
        if(left[i] >= right[j]){
            arr[i + j] = left[i]
            i += 1
        }else{
            arr[i + j] = right[j]
            j += 1
        }
    }

    while(i < left.size){
        arr[i + j] = left[i]
        i += 1
    }

    while(j < right.size){
        arr[i + j] = right[j]
        j += 1
    }

    return arr
}