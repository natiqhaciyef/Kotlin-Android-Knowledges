package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


/**
 * Example:
 * var ti = TreeNodeBSTIterator(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 *
 */

class TreeNodeBSTIterator(var `val`: Int) {
    var left: TreeNodeBSTIterator? = null
    var right: TreeNodeBSTIterator? = null
}

class BSTIterator(val root: TreeNodeBSTIterator?) {
    private var head = -1
    private var currentList = mutableListOf<TreeNodeBSTIterator>()

    init {
        if (root != null) dfs(root)
        // bfs(root)
    }

    private fun dfs(head: TreeNodeBSTIterator) {
        if (head.left != null)
            dfs(head.left!!)

        currentList.add(head)

        if (head.right != null)
            dfs(head.right!!)
    }

    fun next(): Int {
        // println(currentList.map{ it.`val` })
        head += 1
        if (currentList.size <= head)
            return -1

        return currentList[head].`val`
    }

    fun hasNext(): Boolean {
        // println("list size = ${currentList.size}")
        // println("head = $head")
        return currentList.size - 1 > head
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */