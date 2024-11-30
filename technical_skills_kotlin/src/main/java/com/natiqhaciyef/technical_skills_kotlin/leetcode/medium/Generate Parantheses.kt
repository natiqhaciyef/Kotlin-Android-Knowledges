package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun nextPermutation(nums: IntArray): Unit {
    var first = nums.lastIndex - 1
    var second = nums.lastIndex

    if (nums.size < 3) {
        createPermutation(first, second, nums)
        return
    }

    while (true) {
        val created = createPermutation(first, second, nums)
        if (created[first] != nums[first] || created[second] != nums[second]) {
            return
        }

        if (first > 0)
            first -= 1
        else if (second > 2)
            second -= 1
    }

}

fun createPermutation(
    firstIndex: Int,
    secondIndex: Int,
    nums: IntArray
): IntArray {

    nums[firstIndex] = nums[firstIndex] * nums[secondIndex]
    nums[secondIndex] = nums[firstIndex] / nums[secondIndex]
    nums[firstIndex] = nums[firstIndex] / nums[secondIndex]

    return nums
}

fun nextPermutationShortened(nums: IntArray) {
    var i = nums.size - 2
    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--
    }

    if (i >= 0) {
        var j = nums.size - 1
        while (nums[j] <= nums[i]) {
            j--
        }
        nums[i] = nums[j].also { nums[j] = nums[i] }
    }
    nums.reverse(i + 1, nums.size)
}


fun main() {

    nextPermutation(intArrayOf(1, 2, 3))
    nextPermutation(intArrayOf(1, 1, 5))
}

