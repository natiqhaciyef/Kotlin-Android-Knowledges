package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

import com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures.QueueImpl


//class TreeNode(val value: Int) {
//    val children = mutableListOf<TreeNode>()
//    val size = 6
//}
//
//fun dfsIterative(root: TreeNode?) {
//    if (root == null) return
//
//    val stack = ArrayDeque<TreeNode>()
//    stack.addLast(root)
//
//    while (stack.isNotEmpty()) {
//        val current = stack.removeLast()
//        println(current.value)
//
//        for (element in current.children) {
//            stack.addFirst(element)
//        }
//    }
//}
//
//fun dfsRecursive(node: TreeNode?) {
//    if (node == null) return
//
//    println(node.value) // Process the current node
//
//    for (child in node.children) {
//        dfsRecursive(child) // Recursively visit each child
//    }
//}
//
//
//fun main() {
//    // Constructing a sample tree
//    val root = TreeNode(1)
//    val node2 = TreeNode(2)
//    val node3 = TreeNode(3)
//    val node4 = TreeNode(4)
//    val node5 = TreeNode(5)
//    val node6 = TreeNode(6)
//    val node7 = TreeNode(7)
//
//    // Building the tree structure
//    root.children.addAll(listOf(node2, node3, node4))
//    node2.children.add(node5)
//    node3.children.add(node6)
//    node6.children.add(node7)
//
//    // Tree Structure:
//    //        1
//    //      / | \
//    //     2  3  4
//    //    /    \
//    //   5      6
//    //           \
//    //            7
//
//    println("DFS Recursive:")
//    dfsRecursive(root)
//
//    println("\nDFS Iterative:")
//    dfsIterative(root)
//
////    println("\nDFS Current:")
////    dfsCurrent(root)
//}


data class BinaryTreeNode(
    var value: Int,
    var left: BinaryTreeNode? = null,
    var right: BinaryTreeNode? = null,
    var depth: Int = 0
)

class BinaryTree {
    private var root: BinaryTreeNode? = null
    private var size: Int = 0

    fun add(value: Int) {
        if (root == null) {
            root = BinaryTreeNode(value)
            size += 1
            return
        }

        var depth = 0
        var current = root

        while (current != null) {
            depth += 1

            when {
                value > current.value -> {
                    if (current.right != null)
                        current = current.right
                    else {
                        current.right = BinaryTreeNode(value, depth = depth)
                        return
                    }
                }

                value < current.value -> {
                    if (current.left != null)
                        current = current.left
                    else {
                        current.left = BinaryTreeNode(value, depth = depth)
                        return
                    }
                }

                else -> return
            }
        }
    }

    fun bfs(): List<Int> {
        if (this.root == null) return listOf()

        val result = mutableListOf<Int>()
        val queue = QueueImpl<BinaryTreeNode>()
        var current = this.root!!
        queue.enqueue(current)

        while (queue.size > 0) {
            current = queue.dequeue()!!
            result.add(current.value)

            if (current.left != null) {
                queue.enqueue(current.left!!)
            }

            if (current.right != null) {
                queue.enqueue(current.right!!)
            }
        }

        return result
    }

    // In order
    fun inOrderDfs(): List<Int> {
        if (this.root == null) return listOf()
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<BinaryTreeNode>()
        var current: BinaryTreeNode? = this.root

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

    fun inOrderDfsRecursion(): List<Int> {
        if (root == null) return listOf()

        return traverseInOrderDfs(root!!, mutableListOf())
    }

    private fun traverseInOrderDfs(node: BinaryTreeNode, list: MutableList<Int>): List<Int> {
        if (node.left != null)
            traverseInOrderDfs(node.left!!, list)

        list.add(node.value)

        if (node.right != null)
            traverseInOrderDfs(node.right!!, list)

        return list
    }


    // Pre order
    fun preOrderDfs(): List<Int> {
        if (this.root == null) return listOf()

        val result = mutableListOf<Int>()
        val stack = ArrayDeque<BinaryTreeNode>()
        var current = this.root!!
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

    fun preOrderDfsRecursion(): List<Int> {
        if (root == null) return listOf()
        return traversePreOrderDfs(root!!, mutableListOf())
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

    // Post order
    fun postOrderDfs(): List<Int> {
        if (this.root == null) return listOf()

        val result = mutableListOf<Int>()
        val stack = ArrayDeque<BinaryTreeNode>()
        val visited = mutableSetOf<BinaryTreeNode>()
        var current: BinaryTreeNode? = this.root

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

    fun postOrderDfsRecursion(): List<Int> {
        if (this.root == null) return listOf()

        return traversalPostOrderDfs(root!!, mutableListOf())
    }

    private fun traversalPostOrderDfs(node: BinaryTreeNode, list: MutableList<Int>): List<Int> {
        if (node.left != null)
            traversalPostOrderDfs(node.left!!, list)

        if (node.right != null)
            traversalPostOrderDfs(node.right!!, list)

        list.add(node.value)

        return list
    }
}

fun main() {
    val binaryTree = BinaryTree()
    binaryTree.add(12)
    binaryTree.add(41)
    binaryTree.add(8)
    binaryTree.add(24)
    binaryTree.add(48)
    binaryTree.add(4)
    binaryTree.add(2)
    binaryTree.add(9)

    //       12
    //    8      41
    //  4  9    24  48
    // 2

    //  Pre order iterative:
    //  [12, 8, 4, 2, 9, 41, 24, 48]

    //  In order iterative:
    //  [2, 4, 8, 9, 12, 24, 41, 48]

    //  Post order iterative:
    //  [2, 4, 9, 8, 24, 48, 41, 12]

    println(binaryTree.bfs())

    println("Pre order iterative: ")
    println(binaryTree.preOrderDfs())
    println("Pre order recursive: ")
    println(binaryTree.preOrderDfsRecursion())

    println("In order iterative: ")
    println(binaryTree.inOrderDfs())
    println("In order recursive: ")
    println(binaryTree.inOrderDfsRecursion())

    println("Post order iterative: ")
    println(binaryTree.postOrderDfs())
    println("Post order recursive: ")
    println(binaryTree.postOrderDfsRecursion())


}