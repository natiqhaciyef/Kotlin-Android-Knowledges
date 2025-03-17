package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun threeSumWorst(nums: Array<Int>): List<List<Int>> {
    val list = mutableListOf<List<Int>>()

    for (i in nums.indices) {
        for (j in i until nums.size) {
            val temp = 0 - (nums[i] + nums[j])

            if (nums.contains(temp) && j != i)
                if ((nums.indexOf(temp) == i || nums.indexOf(temp) == j) && nums[j] != nums[i] && nums[j] != 0 && nums[i] != 0) {
                    if (nums.count { it == temp } > 1)
                        list.add(listOf(nums[i], nums[j], temp).sorted())
                } else if (nums.indexOf(temp) == i || nums.indexOf(temp) == j && nums[j] != 0 && nums[i] != 0) {
                    if (nums.count { it == temp } > 2)
                        list.add(listOf(nums[i], nums[j], temp).sorted())
                } else {
                    if (nums[j] != 0 && nums[i] != 0) {
                        list.add(listOf(nums[i], nums[j], temp).sorted())
                    }
                }
        }
    }


    return list.toSet().toList()
}

fun threeSumFast(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if (nums.size < 3) return result // Not enough elements to form a triplet

    nums.sort() // Sort the input array

    for (i in 0 until nums.size - 2) {
        if (i == 0 || (nums[i] != nums[i - 1])) {
            var lo = i + 1
            var hi = nums.size - 1
            val target = -nums[i]

            while (lo < hi) {
                when {
                    nums[lo] + nums[hi] == target -> {
                        result.add(listOf(nums[i], nums[lo], nums[hi]))
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--
                        lo++
                        hi--
                    }
                    nums[lo] + nums[hi] < target -> lo++
                    else -> hi--
                }
            }
        }
    }

    return result
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    if (nums.size < 3) return result  // Not enough elements for a triplet

    nums.sort()

    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue  // Skip duplicate numbers

        if (nums[i] > 0) break  // Early exit optimization (since nums[i] + nums[j] + nums[k] > 0)

        var lo = i + 1
        var hi = nums.size - 1

        while (lo < hi) {
            val sum = nums[i] + nums[lo] + nums[hi]

            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[lo], nums[hi]))
                    do { lo++ } while (lo < hi && nums[lo] == nums[lo - 1])  // Skip duplicates
                    do { hi-- } while (lo < hi && nums[hi] == nums[hi + 1])  // Skip duplicates
                }
                sum < 0 -> lo++
                else -> hi--
            }
        }
    }

    return result
}

fun main() {

//    IntArray
    println(threeSum(intArrayOf(-1, 0, 1, 0)))
}