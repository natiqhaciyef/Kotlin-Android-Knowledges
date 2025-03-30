package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.tree_graph

import com.natiqhaciyef.technical_skills_kotlin.algorithms.searching.BinaryTreeNode

fun bfs(head: BinaryTreeNode?): List<Int> {
    if (head == null) return listOf()

    val result = mutableListOf<Int>()
    val queue= ArrayDeque<BinaryTreeNode>()
    var current = head
    queue.addLast(current)

    while (queue.size > 0) {
        current = queue.removeFirst()
        result.add(current.value)

        if (current.left != null) {
            queue.addLast(current.left!!)
        }

        if (current.right != null) {
            queue.addLast(current.right!!)
        }
    }

    return result
}

//        A
//       / \
//      B   C
//     / \   \
//    D   E   F


// In order (D → B → E → A → C → F) -> Left based
fun inOrderDfs(head: BinaryTreeNode?): List<Int> {
    if (head == null) return listOf()
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<BinaryTreeNode>()
    var current: BinaryTreeNode? = head

    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }

        current = stack.removeLast()
        result.add(current.value)

        current = current.right
    }

    return result
}

fun inOrderDfsRecursion(head: BinaryTreeNode?): List<Int> {
    if (head == null) return listOf()

    return traverseInOrderDfs(head, mutableListOf())
}

private fun traverseInOrderDfs(node: BinaryTreeNode, list: MutableList<Int>): List<Int> {
    if (node.left != null)
        traverseInOrderDfs(node.left!!, list)

    list.add(node.value)

    if (node.right != null)
        traverseInOrderDfs(node.right!!, list)

    return list
}



// Pre order (A → B → D → E → C → F) -> Top to left
fun preOrderDfs(head: BinaryTreeNode?): List<Int> {
    if (head == null) return listOf()

    val result = mutableListOf<Int>()
    val stack = ArrayDeque<BinaryTreeNode>()
    var current = head
    stack.addLast(current)

    while (stack.size > 0) {
        current = stack.removeLast()
        result.add(current.value)

        if (current.right != null) {
            stack.addLast(current.right!!)
        }

        if (current.left != null) {
            stack.addLast(current.left!!)
        }
    }

    return result
}

fun preOrderDfsRecursion(head: BinaryTreeNode?): List<Int> {
    if (head == null) return listOf()
    return traversePreOrderDfs(head, mutableListOf())
}

private fun traversePreOrderDfs(
    node: BinaryTreeNode,
    list: MutableList<Int>
): List<Int> {
    list.add(node.value)

    if (node.left != null)
        traversePreOrderDfs(node.left!!, list)

    if (node.right != null)
        traversePreOrderDfs(node.right!!, list)

    return list
}



// Post order (D → E → B → F → C → A)
fun postOrderDfs(head: BinaryTreeNode?): List<Int> {
    if (head == null) return listOf()

    val result = mutableListOf<Int>()
    val stack = ArrayDeque<BinaryTreeNode>()
    val visited = mutableSetOf<BinaryTreeNode>()
    var current: BinaryTreeNode? = head

    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }

        val peekNode = stack.last()

        if (peekNode.right != null && !visited.contains(peekNode.right!!)) {
            current = peekNode.right
        } else {
            stack.removeLast()
            result.add(peekNode.value)
            visited.add(peekNode)
        }
    }

    return result
}

fun postOrderDfsRecursion(head: BinaryTreeNode?): List<Int> {
    if (head == null) return listOf()

    return traversalPostOrderDfs(head, mutableListOf())
}

private fun traversalPostOrderDfs(node: BinaryTreeNode, list: MutableList<Int>): List<Int> {
    if (node.left != null)
        traversalPostOrderDfs(node.left!!, list)

    if (node.right != null)
        traversalPostOrderDfs(node.right!!, list)

    list.add(node.value)

    return list
}
