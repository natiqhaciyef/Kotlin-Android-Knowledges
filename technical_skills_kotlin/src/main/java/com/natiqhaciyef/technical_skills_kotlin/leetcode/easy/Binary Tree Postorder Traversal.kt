package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun postorderTraversal(root: TreeNode?): List<Int> {
    return postOrder(root, mutableListOf<Int>())
}

fun postOrder(node: TreeNode?, list: MutableList<Int>): MutableList<Int>{
    if(node?.left != null)
        postOrder(node?.left, list)

    if(node?.right != null)
        postOrder(node?.right, list)

    if(node != null)
        list.add(node!!.`val`)

    return list
}