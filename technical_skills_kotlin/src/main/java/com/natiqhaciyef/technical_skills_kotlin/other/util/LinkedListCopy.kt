package com.natiqhaciyef.technical_skills_kotlin.other.util

data class Node(var data: Int) {
    var prev: Node? = null
}

class LinkedListCopy {
    var node: Node? = null

    fun addNode(data: Int) {
        if (this.node == null) {
            this.node = Node(data)
        } else {
            val copy = Node(this.node?.data!!)
            copy.prev = this.node?.prev

            this.node?.prev = copy
            this.node?.data = data
        }
    }

    fun printLinkedList(){
        var str = ""
        var temp = this.node?.copy()
        while(temp != null){
            str += "${temp.data} - "
            temp = this.node?.prev
        }

        println(str)
    }
}


fun main() {
    val llc = LinkedListCopy()
    llc.addNode(12)
    llc.addNode(20)
    llc.addNode(88)
    llc.addNode(49)
}