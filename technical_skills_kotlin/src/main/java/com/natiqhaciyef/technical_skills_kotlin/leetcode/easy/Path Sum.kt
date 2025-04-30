package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private val list = mutableListOf<TreeNode>()
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    dfs(root, targetSum)
    println(list)

    for (node in list) {
        if (node.left == null && node.right == null)
            return true
    }

    return false
}

fun dfs(node: TreeNode?, targetSum: Int) {
    val nodeValue = node?.`val` ?: 0
    // println("node - ${nodeValue}")
    // println("target - ${targetSum - nodeValue}")

    if (node?.left != null)
        dfs(node.left, targetSum - node.`val`)

    if (node?.right != null)
        dfs(node.right, targetSum - node.`val`)

    println("node - $nodeValue")
    println("target - ${targetSum - nodeValue}")

    if (targetSum == 0 && node != null)
        list.add(node)

    return
}