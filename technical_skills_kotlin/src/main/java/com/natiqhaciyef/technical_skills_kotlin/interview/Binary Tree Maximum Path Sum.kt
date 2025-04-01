package com.natiqhaciyef.technical_skills_kotlin.interview

import com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph.TreeNode
import kotlin.math.max

var result = Integer.MIN_VALUE

fun maxPathSum(root: TreeNode?): Int {
    recursivePostOrder(root)
    return result
}

fun recursivePostOrder(root: TreeNode?): Int{
    if(root == null) return 0
    val left = max(recursivePostOrder(root.left), 0)
    val right = max(recursivePostOrder(root.right), 0)
    result = max(result, root.`val` + left + right)
    return max(left, right) + root.`val`
}