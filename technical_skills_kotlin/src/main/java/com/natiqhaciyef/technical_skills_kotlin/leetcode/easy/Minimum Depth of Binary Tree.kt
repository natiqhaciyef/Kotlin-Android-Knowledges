package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


class TreeNodeMinDepth(var `val`: Int) {
    var left: TreeNodeMinDepth? = null
    var right: TreeNodeMinDepth? = null
}

fun minDepth(root: TreeNodeMinDepth?): Int {
    if (root == null || (root.right == null && root.left == null)) return 0
    val dfsList = dfsTraversal(root!!, mutableListOf(), 1)
    return dfsList.min()
}

fun dfsTraversal(node: TreeNodeMinDepth, list: MutableList<Int>, level: Int): MutableList<Int> {
    if (node.left != null)
        dfsTraversal(node.left!!, list, level + 1)

    list.add(level)

    if (node.right != null)
        dfsTraversal(node.right!!, list, level + 1)

    return list
}