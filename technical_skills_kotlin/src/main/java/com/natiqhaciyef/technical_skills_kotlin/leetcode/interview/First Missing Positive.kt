package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun firstMissingPositive(nums: IntArray): Int {
    // find the number between positives
    // otherwise if min number is equals one we take the max number

    // we will use hash map for storing max-min range numbers
    val map = mutableMapOf<Int, Boolean>()
    var min = nums[0]
    var max = 0

    // first part scroll between the positives
    for(num in nums){
        // we should find the max of the array
        if (num > max)
            max = num

        // we should find the min of the array, but also positive
        if((num < min && num > 0) || min <= 0)
            min = num

        map[num] = true
    }

    // still we have an edge cases
    // if missing number is not inside our range, we should handle it
    // with two possible solution, and one edge case
    // 1. min number is higher than 1 so we should return min-1
    // 2. min number equals to 1 we will return max+1
    // 3. if min and max both of them are lower than zero we should returun 1
    if(min > 1 || max <= 0)
        return 1

    // we will iterate between the range and find the missing positive number
    for(i in min .. max){
        if(map[i] == null)
            return i
    }

    // last case is if every step checked after that max+1 is the last case
    return max+1
}