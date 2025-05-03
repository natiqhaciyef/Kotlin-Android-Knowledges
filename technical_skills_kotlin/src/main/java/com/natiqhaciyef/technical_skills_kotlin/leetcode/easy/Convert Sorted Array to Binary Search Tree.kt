package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun sortedArrayToBST(nums: IntArray): TreeNode? {

    return constructBST(nums, 0, nums.size - 1)
}

private fun constructBST(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) return null

    val mid = left + (right - left) / 2
    val node = TreeNode(nums[mid])

    node.left = constructBST(nums, left, mid - 1)
    node.right = constructBST(nums, mid + 1, right)

    return node
}