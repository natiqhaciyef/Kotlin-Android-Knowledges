package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph

class TreeNodeLCA (var `val`: Int = 0) {
    var left: TreeNodeLCA? = null
    var right: TreeNodeLCA? = null
}

fun lowestCommonAncestor(root: TreeNodeLCA?, p: TreeNodeLCA?, q: TreeNodeLCA?): TreeNodeLCA? {
    if (root == null || root == p || root == q) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    return when {
        left != null && right != null -> root  // If p and q are found in different subtrees, root is LCA
        left != null -> left  // If found in left subtree
        else -> right  // If found in right subtree
    }
}