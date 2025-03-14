package com.natiqhaciyef.technical_skills_kotlin.other.customization

class DoublyNode<T>(var data: T, var prev: DoublyNode<T>? = null, var next: DoublyNode<T>? = null)

class DoublyLinkedList<T> {
    private var head: DoublyNode<T>? = null
    private var tail: DoublyNode<T>? = null
    private var size: Int = 0  // Track the size

    // Get the size of the list
    fun getSize(): Int {
        return size
    }

    fun push(value: T) {
        val newNode = DoublyNode(value, null, head)
        head?.prev = newNode
        head = newNode
        size++
    }

    // Delete a node with a given value
    fun delete(value: T) {
        var current = head
        while (current != null) {
            if (current.data == value) {
                if (current.prev != null) {
                    current.prev?.next = current.next
                } else {
                    head = current.next
                }
                if (current.next != null) {
                    current.next?.prev = current.prev
                } else {
                    tail = current.prev
                }
                size--  // Decrease size
                return
            }
            current = current.next
        }
    }

    // Display list from head to tail
    fun displayForward() {
        var current = head
        while (current != null) {
            print("${current.data} ⇄ ")
            current = current.next
        }
        println("null")
    }

    fun findFirst(): DoublyNode<T>? {
        return head
    }
}

// Example Usage
fun main() {
    val list = DoublyLinkedList<Int>()

    list.push(10)
    list.push(20)
    list.push(30)
    list.push(45)

    list.displayForward()

    val new = list.reverseLinkedList()
    new?.displayForward()

//    println("List size: ${list.getSize()}")  // 3
//    println("Forward:")
//    list.displayForward() // Output: 30 ⇄ 10 ⇄ 20 ⇄ null
//
//    println("Deleting 10...")
//    list.delete(10)
//
//    println("List size: ${list.getSize()}")  // 2
//    println("Is list empty? ${list.isEmpty()}")  // false
//    list.displayForward() // Output: 30 ⇄ 20 ⇄ null

//    println(list.findFirst()?.data)
}


val customLinkedList = DoublyLinkedList<Int>()

fun DoublyLinkedList<Int>.reverseLinkedList(): DoublyLinkedList<Int>? {
    if (this.getSize() == 0) println("ALMA")

    // I should create reverse mechanism with recursion
    this.findFirst()?.reverseItem()
    return customLinkedList
}

fun DoublyNode<Int>.reverseItem() {
    val current = this.next

    current?.reverseItem()
    customLinkedList.push(this.data)

    if (current == null)
        return
}
