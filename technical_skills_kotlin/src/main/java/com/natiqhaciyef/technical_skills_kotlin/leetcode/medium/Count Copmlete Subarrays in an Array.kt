package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


// first solution
fun countCompleteSubarraysWorst(nums: IntArray): Int {
    // edge case
    if(nums.size == 0) return 0

    // Condition: Each number can be used only once (for finding sum)
    // Condition: Subarray can hold same numbers if exists

    // Step1: Find whole sum
    // Step2:

    // Techniques: Array, Hash Table, Sliding Window

    // create map which collects all numbers with count
    val sum = findDistinctSum(nums, 0, nums.size-1)

    var start = 0
    var end = nums.size-1
    var currentEnd = nums.size-1

    var result = 0
    var currentResult = result

    // println("sum: $sum")

    while(start <= end){
        // sliding window
        val subSum = findDistinctSum(nums, start, end)
        // println("sub sum: $subSum")
        if(subSum == sum)
            result+=1

        // change current values of
        // First
        // [1,2,1,3,4] -> index start = 0, end = 4

        // Second
        // [1,2,1,3] -> index start = 0, end = 3
        // [2,1,3,4] -> index start = 1, end = 4

        // Third
        // [1,2,1] -> index start = 0, end = 2
        // [2,1,3] -> index start = 1, end = 3
        // [1,3,4] -> index start = 2, end = 4

        //...
        // println("start: $start")
        // println("end: $end")
        // println("--------")
        if(end == nums.size-1){
            if(currentResult == result)
                return result
            else
                currentResult = result
            currentEnd -= 1
            start = 0
            end = currentEnd
        }else{
            start += 1
            end += 1
        }
    }

    return result
}

fun findDistinctSum(arr: IntArray, from: Int, to: Int): Int{
    val map = mutableMapOf<Int, Int>()
    var sum = 0

    for(i in from .. to){
        map[arr[i]] = 1
    }

    for(key in map.keys){
        sum += key
    }

    // println("set: $set")
    return sum
}


// second solution
fun countCompleteSubarrays(nums: IntArray): Int {
    val totalDistinct = nums.toSet().size
    var count = 0

    for (start in nums.indices) {
        val seen = mutableSetOf<Int>()
        for (end in start until nums.size) {
            seen.add(nums[end])
            if (seen.size == totalDistinct) {
                count++
            }
        }
    }

    return count
}
