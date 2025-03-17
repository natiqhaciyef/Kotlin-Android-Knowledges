package com.natiqhaciyef.technical_skills_kotlin.other.customization


class Node<T : Any>(
    var value: T,
    var next: Node<T>? = null,
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }

    fun printReversed() {
        println("i$value")
        next?.printReversed()

        if (next != null) {
            print(" -> ")
        }

        print(value.toString())
    }
}

interface LinkedList<T : Any> {
    var head: Node<T>?
    var tail: Node<T>?

    var size: Int
    val hasNext: Boolean

    fun insertHead(value: T)

    fun insertTail(value: T)

    fun printNodes()

    fun nodeAt(value: Int): Node<T>?

    fun indexOf(value: T): Int?

    fun insert(value: T, afterNode: Node<T>)

    fun remove(value: T)

    fun removeAfter(node: Node<T>)

    fun pop()

    fun removeLast()
}


data class LinkedListImpl<T : Any>(
    val nodes: Node<T>? = null
) : LinkedList<T> {
    override var head: Node<T>? = nodes
    override var tail: Node<T>? = null

    override var size: Int = 0
    override val hasNext: Boolean
        get() = head?.next != null


    override fun printNodes() {
        println(head.toString())
    }

    override fun insertHead(value: T) {
        head = Node(value = value, next = head)

        if (tail == null) {
            tail = head
        }

        size += 1
    }

    override fun insertTail(value: T) {
        if (size == 0) {
            insertHead(value)
            return
        }

        val newNode = Node(value)
        tail!!.next = newNode
        tail = newNode

        size += 1
    }

    override fun nodeAt(index: Int): Node<T>? {
        var currentNode: Node<T>? = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex += 1
        }

        return currentNode
    }

    override fun indexOf(value: T): Int? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode?.next != null && currentNode.value != value) {
            currentNode = currentNode.next
            currentIndex += 1
        }

        return currentIndex
    }

    override fun insert(value: T, afterNode: Node<T>) {
        if (tail == afterNode) {
            insertTail(value)
        }

        val newNode = Node(value, next = afterNode.next)
        afterNode.next = newNode
        size += 1
    }

    override fun remove(value: T) {
        if (size == 0) return
        if (head?.value == value) {
            head = head?.next
            printNodes()

            return
        }

        var currentNode = head

        while (currentNode?.next != null) {
            currentNode = currentNode.next

            if (currentNode?.next?.value == value) {
                currentNode.next = currentNode.next?.next
                size -= 1

                break
            }
        }
    }

    override fun pop() {
        if (size == 0) return

        head = head?.next
        size -= 1

        if (size == 0) {
            tail = null
        }
    }

    override fun removeLast() {
        val head = head ?: return
        if (head.next == null) pop()

        var prev = head
        var current = head
        var next = head.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
    }

    fun getAt(index: Int): Node<T>? {
        var current = this.head
        var counter = 0

        while (current?.next != null) {
            current = current.next

            if (index == counter)
                return current!!

            counter += 1
        }

        return null
    }

    override fun removeAfter(node: Node<T>) {
        if (node.next == tail) tail = node
        if (node.next != null) size -= 1
        node.next = node.next?.next
    }

    fun reverse() {
        val linkedList: LinkedList<T> = this
        var headTemp = this.head
        val currentSize = linkedList.size

        while (headTemp?.next != null) {
            linkedList.insertHead(headTemp.value)
            headTemp = headTemp.next
        }

        repeat(currentSize) {
            removeLast()
        }

        size /= 2
        linkedList.insertHead(headTemp?.value!!)
//        linkedList.printNodes()

        this.head = linkedList.head
    }

    fun reverse(head: Node<T>?): Node<T>? {
        var prev: Node<T>? = null
        var current = head

        //49 -> 12 -> 469 -> 9 -> 5 -> 77
        while (current != null) {
            val next = current.next  // Store next node
            current.next = prev      // Reverse pointer
            prev = current           // Move prev forward
            current = next           // Move current forward

            println(prev)
        }
        return prev  // New head of reversed list
    }
}

fun <T : Any> LinkedListImpl<T>.printInReversed() {
    this.nodeAt(0)?.printReversed()
}

fun <T : Any> LinkedListImpl<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null) {
        fast = fast?.next

        if (fast != null) {
            fast = fast?.next
            slow = slow?.next
        }
    }
    return slow
}

fun reverseLinkedList(linkedList: LinkedListImpl<Int>): LinkedListImpl<Int>? {
    val customLinkedList = LinkedListImpl<Int>()
    val firstNode = linkedList.nodeAt(0) ?: return null
    firstNode.reverseNode(customLinkedList)
    return customLinkedList
}

fun Node<Int>.reverseNode(linkedList: LinkedList<Int>) {
    this.next?.reverseNode(linkedList)
    linkedList.insertHead(this.value)
    return
}

fun main() {
    val linkedList = LinkedListImpl<Int>()

    linkedList.insertHead(49)
    linkedList.insertTail(12)
    linkedList.insertTail(469)
    linkedList.insertTail(9)
    linkedList.insertTail(5)
    linkedList.insertTail(77)
//    linkedList.push(8)
//    linkedList.push(19)
//
//    linkedList.append(100000)
//    linkedList.append(4666)
//
//    val afterNode = linkedList.nodeAt(3)
//    linkedList.insert(71, afterNode!!)
//
////    val findNodeIndex = linkedList.indexOf(77)
////    println(findNodeIndex)
//
//    linkedList.printNodes()
//
//    linkedList.remove(77)
//    linkedList.removeLast()
//    linkedList.pop()

    println("Nodes")
    linkedList.printNodes()
    println()
    println("Reversed")
//    linkedList.reverse()
    println(linkedList.reverse(linkedList.head))
//    linkedList.printNodes()
//    linkedList.printNodes()
}
