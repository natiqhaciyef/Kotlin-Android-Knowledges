package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun isBalanced(root: TreeNode?): Boolean {
    return height(root) != -1
}

private fun height(node: TreeNode?): Int {
    if (node == null) return 0

    val leftHeight = height(node.left)
    if (leftHeight == -1) return -1  // Early return if unbalanced

    val rightHeight = height(node.right)
    if (rightHeight == -1) return -1  // Early return if unbalanced

    if (Math.abs(leftHeight - rightHeight) > 1) return -1

    return maxOf(leftHeight, rightHeight) + 1
}