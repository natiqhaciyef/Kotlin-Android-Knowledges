package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

import java.util.LinkedList
import java.util.Queue

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true

    val queue: Queue<TreeNode?> = LinkedList()
    queue.add(root.left)
    queue.add(root.right)

    while (queue.isNotEmpty()) {
        val t1 = queue.poll()
        val t2 = queue.poll()

        if (t1 == null && t2 == null) continue
        if (t1 == null || t2 == null || t1.`val` != t2.`val`) return false

        queue.add(t1.left)
        queue.add(t2.right)
        queue.add(t1.right)
        queue.add(t2.left)
    }

    return true
}