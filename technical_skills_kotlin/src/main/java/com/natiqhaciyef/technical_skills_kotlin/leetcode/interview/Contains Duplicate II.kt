package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview


fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val hashMap = hashMapOf<Int, Int>()
    for (i in nums.indices) {

        if (hashMap.containsKey(nums[i])) {
            if (i - hashMap[nums[i]]!! <= k)
                return true

            hashMap[nums[i]] = i
        } else {
            hashMap[nums[i]] = i
        }
    }

    return false
}