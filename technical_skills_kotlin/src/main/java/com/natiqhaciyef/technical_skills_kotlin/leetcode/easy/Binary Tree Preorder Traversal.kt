package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun preorderTraversal(root: TreeNode?): List<Int> {
    if(root == null) return listOf()
    return preOrder(root, mutableListOf())
}

fun preOrder(node: TreeNode?, result: MutableList<Int>): MutableList<Int>{
    val num = node?.`val` ?: return result

    result.add(num)

    if(node.left != null)
        preOrder(node.left, result)

    if(node.right != null)
        preOrder(node.right, result)

    return result
}