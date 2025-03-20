package com.natiqhaciyef.technical_skills_kotlin.other.customization

data class BinaryNode(
    var value: Int,
    var left: BinaryNode? = null,
    var right: BinaryNode? = null,
    var depth: Int = 0
)

class BinarySearchTree {
    private var root: BinaryNode? = null

    fun insert(value: Int) {
        if (root == null) {
            root = BinaryNode(value)
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
                        current.right = BinaryNode(value, depth = depth)
                        return
                    }
                }

                value < current.value -> {
                    if (current.left != null)
                        current = current.left
                    else {
                        current.left = BinaryNode(value, depth = depth)
                        return
                    }
                }

                else -> return
            }
        }
    }

    fun remove(value: Int): BinaryNode? {
        var current = root ?: return null
        var foundItem: BinaryNode? = null

        while(current.value != value){
            foundItem = if (foundItem == null) root else current

            when{
                value > current.value -> {
                    current = current.right ?: return null
                }

                else -> {
                    current = current.left ?: return null
                }
            }
        }

        when {
            current.right != null -> {
                if (foundItem!!.value > current.value){
                    foundItem.left = current.right
                    foundItem.left?.depth = current.depth
                }
                else {
                    foundItem.right = current.right
                    foundItem.right?.depth = current.depth
                }
            }

            current.left != null -> {
                if (foundItem!!.value > current.value) {
                    foundItem.left = current.left
                    foundItem.left?.depth = current.depth
                }else {
                    foundItem.right = current.left
                    foundItem.right?.depth = current.depth
                }
            }
        }

        return root
    }

    fun find(value: Int): BinaryNode?{
        var current = root

        while (current != null){
            when{
                value > current.value -> current = current.right
                value < current.value -> current = current.left
                else -> return current
            }
        }

        return null
    }
}

fun main() {
    val binaryTree = BinarySearchTree()
    binaryTree.insert(12)
    binaryTree.insert(41)
    binaryTree.insert(8)
    binaryTree.insert(24)
    binaryTree.insert(48)
    binaryTree.insert(4)
    binaryTree.insert(2)
    binaryTree.insert(9)


    println(binaryTree.find(41))

//    println(binaryTree.remove(41))
}