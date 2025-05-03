package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return listOf()

    val result = mutableListOf<Int>()
    val stack = ArrayDeque<TreeNode>()
    var current: TreeNode? = root

    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }

        current = stack.removeLast()
        result.add(current.`val`)

        current = current.right
    }

    return result
}