package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph

import kotlin.math.abs

class TreeNodeBalance(var `val`: Int) {
    var left: TreeNodeBalance? = null
    var right: TreeNodeBalance? = null
}

fun isBalanced(root: TreeNodeBalance?): Boolean {
    return height(root) != -1
}

private fun height(node: TreeNodeBalance?): Int {
    if (node == null) return 0

    val leftHeight = height(node.left)
    if (leftHeight == -1) return -1  // Early return if unbalanced

    val rightHeight = height(node.right)
    if (rightHeight == -1) return -1  // Early return if unbalanced

    if (abs(leftHeight - rightHeight) > 1) return -1

    return maxOf(leftHeight, rightHeight) + 1
}