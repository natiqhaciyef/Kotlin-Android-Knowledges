package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph


fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true // Both nodes are null, trees are identical
    if (p == null || q == null || p.`val` != q.`val`) return false // One is null or values mismatch

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) // Check left & right subtrees
}
