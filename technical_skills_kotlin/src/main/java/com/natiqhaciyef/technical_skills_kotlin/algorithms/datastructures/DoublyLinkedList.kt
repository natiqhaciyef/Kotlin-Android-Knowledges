package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures


class DoublyNode<T : Any>(
    var data: T,
    var next: DoublyNode<T>? = null,
    var prev: DoublyNode<T>? = null
)

class DoublyLinkedList<T : Any> {
    private var head: DoublyNode<T>? = null
    private var tail: DoublyNode<T>? = null
    private var length = 0

    private fun createNode(value: T): DoublyNode<T> {
        return DoublyNode(value)
    }

    private fun isInitialStageApplied(node: DoublyNode<T>): Boolean {
        var result = false
        if (tail == null) {
            tail = node
            result = true
        }

        if (head == null) {
            head = node
            result = true
        }

        return result
    }

    fun getAt(index: Int): DoublyNode<T>? {
        var counter = 0
        var current = head
        while (counter < index && current?.next != null) {
            current = current.next
            counter += 1
        }

        return current
    }

    fun printList() {
        var current = head
        while (current?.next != null) {
            print("${current.data} -> ")
            current = current.next
        }

        print("${current?.data}")
    }

    // 2 -> 1 ->
    fun insertToHead(value: T) {
        val newNode = createNode(value)
        if (isInitialStageApplied(newNode))
            return

        head?.prev = newNode
        newNode.next = head
        head = newNode

        length += 1
    }

    fun insertToTail(value: T) {
        val newNode = createNode(value)

        if (isInitialStageApplied(newNode))
            return

        tail?.next = newNode
        newNode.prev = tail
        tail = newNode

        length += 1
    }

    fun insertAfter(index: Int, value: T) {
        val newNode = createNode(value)

        if (isInitialStageApplied(newNode))
            return

        val currentInIndex = getAt(index)
        val holdingNext = currentInIndex?.next
        currentInIndex?.next = newNode
        newNode.prev = currentInIndex

        newNode.next = holdingNext
        holdingNext?.prev = newNode
    }

    // write remove functions
    fun removeTail() {
        tail = tail?.prev
        tail?.next = null
    }

    fun removeHead() {
        head = head?.next
        head?.prev = null
    }

    fun removeIndexOf(index: Int) {
        val elementOfIndex = getAt(index)
        val prev = elementOfIndex?.prev
        val next = elementOfIndex?.next

        prev?.next = next
        next?.prev = prev
    }

    fun findIndexOf(value: T): Int {
        var current = head
        var counter = 0

        while (current?.next != null) {
            if (current.data == value)
                return counter

            current = current.next
            counter += 1
        }

        return -1
    }
}

fun main() {
    val doublyLinkedList = DoublyLinkedList<Int>()
    doublyLinkedList.insertToHead(12)
    doublyLinkedList.insertToTail(41)
    doublyLinkedList.insertToTail(99)
    doublyLinkedList.insertToTail(0)
    doublyLinkedList.insertToTail(4)
    doublyLinkedList.insertToTail(8)

    doublyLinkedList.insertAfter(2, 21)

    doublyLinkedList.printList()
    println()
    println(doublyLinkedList.getAt(2)?.data)
    doublyLinkedList.removeHead()
    doublyLinkedList.printList()
    println()

    println(doublyLinkedList.findIndexOf(99))
    println(doublyLinkedList.findIndexOf(1))

    mergeAlternately("ab", "pqrs")
}

fun mergeAlternately(word1: String, word2: String): String {
    var result = ""
    val size = minOf(word1.length, word2.length)
    val element = if(word1.length == size) word2 else word1



    println("Size: $size")
    println("Element: $element")

    for (i in 0 until size){
        result += word1[i]
        result += word2[i]
    }

    if(word1.length != word2.length) {
        val new = element.substring(size, element.lastIndex+1)
        result += new
        println("In")
    }

    println(result)

    return result
}
