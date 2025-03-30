package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

var diameter = 0
fun diameterOfBinaryTree(root: TreeNode?): Int {
    dfs(root) // Start DFS traversal
    return diameter
}

// Helper function to calculate the height of the tree
private fun dfs(node: TreeNode?): Int {
    if (node == null) return 0 // If node is null, return height 0

    val leftHeight = dfs(node.left) // Get the height of the left subtree
    val rightHeight = dfs(node.right) // Get the height of the right subtree

    // The diameter at the current node is the sum of left and right heights
    diameter = maxOf(diameter, leftHeight + rightHeight)

    // Return the height of the current node
    return 1 + maxOf(leftHeight, rightHeight)
}