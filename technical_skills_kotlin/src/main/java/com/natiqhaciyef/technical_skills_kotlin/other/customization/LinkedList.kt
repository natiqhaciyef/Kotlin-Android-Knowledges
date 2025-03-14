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

    fun push(value: T)

    fun append(value: T)

    fun printNodes()

    fun nodeAt(value: Int): Node<T>?

    fun indexOf(value: T): Int?

    fun insert(value: T, afterNode: Node<T>)

    fun remove(value: T)

    fun removeAfter(node: Node<T>)

    fun pop()

    fun removeLast()
}


class LinkedListImpl<T : Any>(
    nodes: Node<T>? = null
) : LinkedList<T> {
    override var head: Node<T>? = nodes
    override var tail: Node<T>? = null

    override var size: Int = 0
    override val hasNext: Boolean
        get() = head?.next != null


    override fun printNodes() {
        println(head.toString())
    }

    override fun push(value: T) {
        head = Node(value = value, next = head)

        if (tail == null) {
            tail = head
        }

        size += 1
    }

    override fun append(value: T) {
        if (size == 0) {
            push(value)
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
            append(value)
        }

        val newNode = Node(value, next = afterNode.next)
        afterNode.next = newNode
        size += 1
    }

    override fun remove(value: T) {
        if (size == 0) return

        var currentNode = head
        var currentIndex = 0

        while (currentNode?.next != null) {
            currentNode = currentNode.next
            currentIndex += 1

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

    override fun removeAfter(node: Node<T>) {
        if (node.next == tail) tail = node
        if (node.next != null) size -= 1
        node.next = node.next?.next
    }
}

fun main() {
    val linkedList = LinkedListImpl<Int>()

    linkedList.push(49)
    linkedList.push(12)
    linkedList.push(469)
    linkedList.push(9)
    linkedList.push(5)
    linkedList.push(77)
    linkedList.push(8)
    linkedList.push(19)

    linkedList.append(100000)
    linkedList.append(4666)

    val afterNode = linkedList.nodeAt(3)
    linkedList.insert(71, afterNode!!)

//    val findNodeIndex = linkedList.indexOf(77)
//    println(findNodeIndex)

    linkedList.printNodes()

    linkedList.remove(77)
    linkedList.removeLast()
    linkedList.pop()
    linkedList.printNodes()
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


fun reverseLinkedList(linkedList: LinkedListImpl<Int>): LinkedListImpl<Int>?{
    val customLinkedList = LinkedListImpl<Int>()
    val firstNode = linkedList.nodeAt(0) ?: return null
    firstNode.reverseNode(customLinkedList)
    return customLinkedList
}

fun Node<Int>.reverseNode(linkedList: LinkedList<Int>){
    this.next?.reverseNode(linkedList)
    linkedList.push(this.value)
    return
}