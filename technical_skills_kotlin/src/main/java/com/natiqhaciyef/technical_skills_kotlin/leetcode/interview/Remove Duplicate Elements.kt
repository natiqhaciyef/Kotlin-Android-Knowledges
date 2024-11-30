package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun removeDuplicatesInefficient(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    // handle nums size 2 or below

    if (nums.isEmpty())
        return 0

    if (nums.size in 1..2)
        return 1

    // find duplicates
    // replace with last element in list

    // find unique numbers count

    var current = 0
    // 0
    do {
        // 0
        for (next in current + 1 until nums.size) {

            // true
            if (nums[current] == nums[next]) {
                // repeated number found
                set.add(nums[next])

                // 4
                for (index in nums.size - 1 downTo next + 1) {
                    if (nums[index] != nums[next] && !set.contains(nums[index])) {
                        // same element found
                        // change the place of element
                        val temp = nums[next]
                        nums[next] = nums[index]
                        nums[index] = temp
                        break
                    }
                }

            }

        }

        current += 1
    } while (current < nums.size - 1)


    val count = nums.count { !set.contains(it) } + set.size
    var index = 0
    while (index in 0 until count - 1) {
        val min = nums[index]
        if (min > nums[index + 1]) {
            nums[index] = nums[index + 1]
            nums[index + 1] = min
            index = 0
        }

        index += 1
    }

// check if last element is not the same as current number
// O(N^3) + O(N^2)

    println(nums.toList())

    return count
}

fun removeDuplicatesEfficient(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var writeIndex = 1

    for (readIndex in 1 until nums.size) {
        if (nums[readIndex] != nums[readIndex - 1]) {
            nums[writeIndex] = nums[readIndex]
            writeIndex++
        }
        println(nums.toList())
    }

    return writeIndex
}


fun main() {
    val arr1 = intArrayOf(1, 1, 2, 4)
    val arr2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val arr3 = intArrayOf(0, 0, 0, 1, 2, 2, 3, 4)
    val arr4 = intArrayOf(0, 0, 0, 1, 6, 6, 2, 3, 4, 8, 0, 9)
    println(removeDuplicatesEfficient(arr1))
    println(removeDuplicatesEfficient(arr2))
    println(removeDuplicatesEfficient(arr3))
    println(removeDuplicatesEfficient(arr4))
}

//Input: nums = [1,1,2,4]
//Output: 3, nums = [1,2,4,_,_]

//Input: nums = [1,1,2,4,1]
//Output: 3, nums = [1,2,4,_,_,_]

//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).

//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).