package com.natiqhaciyef.technical_skills_kotlin.interview

class LRUCache(private val capacity: Int) {

    private data class Node(
        var key: Int, var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    private val cache = HashMap<Int, Node>()
    private val head = Node(0, 0) // Dummy head
    private val tail = Node(0, 0) // Dummy tail

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            val node = cache[key]!!
            node.value = value
            moveToHead(node)
        } else {
            if (cache.size >= capacity) {
                removeLeastRecentlyUsed()
            }
            val newNode = Node(key, value)
            cache[key] = newNode
            addToHead(newNode)
        }
    }

    private fun addToHead(node: Node) {
        node.next = head.next //
        node.prev = head
        head.next!!.prev = node
        head.next = node
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeNode(node: Node) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }

    private fun removeLeastRecentlyUsed() {
        val lruNode = tail.prev!!
        cache.remove(lruNode.key)
        removeNode(lruNode)
    }

    fun display() {
        var curr = head.next
        while (curr != tail) {
            print("${curr?.key} -> ")
            curr = curr?.next
        }
        println("NULL")
    }
}

fun main() {
    val lru = LRUCache(3)

    lru.put(1, 10)
    lru.put(2, 20)
    lru.put(3, 30)
    lru.display()  // Output: 3 -> 2 -> 1 -> NULL

    println(lru.get(2))     // Access key 2
    lru.display()  // Output: 2 -> 3 -> 1 -> NULL

    lru.put(4, 40) // Evicts least recently used (key 1)
    lru.display()  // Output: 4 -> 2 -> 3 -> NULL
}
