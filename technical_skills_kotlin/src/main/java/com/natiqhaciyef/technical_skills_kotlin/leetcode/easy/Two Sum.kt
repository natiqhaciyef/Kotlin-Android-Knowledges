package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun twoSumSecond(arr: IntArray, target: Int): IntArray {
    val size = arr.size
    val sorted = arr.sorted()
    var leftIndex = 0
    var rightIndex = size-1

    var result = intArrayOf()

    while(leftIndex < rightIndex){
        when {
            sorted[leftIndex] + sorted[rightIndex] > target -> rightIndex -=1
            sorted[leftIndex] + sorted[rightIndex] < target -> leftIndex +=1
            else -> {
                result = intArrayOf(sorted[leftIndex], sorted[rightIndex])
                break
            }
        }
    }

    if(result.isNotEmpty()){
        var firstIndex = -1
        var secondIndex = -1

        for(i in arr.indices){
            if(arr[i] == result[0] && firstIndex == -1)
                firstIndex = i

            if(arr[i] == result[1] && secondIndex == -1 && firstIndex != i)
                secondIndex = i
        }

        return intArrayOf(firstIndex, secondIndex)
    }

    return intArrayOf()
}

fun twoSum(arr: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for(i in arr.indices){
        val dif = target - arr[i]
        if(map.containsKey(dif)){
            return intArrayOf(map[dif]!!, i)
        }

        map[arr[i]] = i
    }

    return intArrayOf()
}
