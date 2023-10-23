package com.natiqhaciyef.kotlinandroidknowledges.algorithms.custom_collections


class CustomLinkedList {
    private var node: Node<Int>? = null

    fun addNode(data: Int) {
        if (node == null) {
            node = Node(data)
        } else {
            val temp = node
            node = Node(data)
            node!!.front = temp
        }
    }

    fun printLinkedList() {
        var copyNode = node
        while (copyNode != null) {
            if (copyNode.front != null)
                print("${copyNode.data}, ")
            else
                print("${copyNode.data}")

            copyNode = copyNode.front
        }
    }

    fun removeNode(){
        node = node?.front
    }
}

