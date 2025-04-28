package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

fun countSubarraysWorst(nums: IntArray, k: Long): Long {
    // create prefix sum
    var sum = 0
    val list = mutableListOf<Int>()
    for(num in nums){
        sum += num
        list.add(sum)
    }
    println(list)

    // sliding window
    var start = 0
    var currentEnd = list.size-1
    var end = currentEnd

    var result = 0L

    while(start <= end){
        val math = if(start> 0){
            (list[end] - list[start-1]) * (end - start+1) * 1L
        }else{
            (list[end]) * (end - start+1) * 1L
        }

        // strictly less than
        if(math < k){
            result +=1
            // println("start: $start")
            // println("end: $end")
        }


        // base condition
        if(end == list.size-1){
            currentEnd -= 1
            end = currentEnd
            start = 0
        }else{
            start += 1
            end += 1
        }
    }

    return result
}

fun countSubarrays(nums: IntArray, k: Long): Long {
    val n = nums.size
    val prefixSum = LongArray(n + 1) { 0L }

    // Prefix sum
    for (i in nums.indices) {
        prefixSum[i + 1] = prefixSum[i] + nums[i]
    }

    // println(prefixSum)

    var result = 0L
    var start = 0

    // Sliding window [5.3.6.1.7.9] => prefixSum [0,5,8,14,15,22,31] => 45
    for (end in nums.indices) {

        // Check if current window is invalid
        while (start <= end) {
            val totalSum = prefixSum[end + 1] - prefixSum[start]
            val length = (end - start + 1).toLong()
            if (totalSum * length < k) {
                break
            }
            start++
        }
        result += (end - start + 1)
    }

    return result
}