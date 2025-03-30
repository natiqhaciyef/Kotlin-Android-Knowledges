package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.linkedlist


class NodeRandom(var value: Int) {
    var next: NodeRandom? = null
    var random: NodeRandom? = null
}

fun copyRandomList(head: NodeRandom?): NodeRandom? {
    if (head == null) return null

    var current: NodeRandom? = head

    // Step 1: Create interleaved copy nodes
    while (current != null) {
        val newNodeRandom = NodeRandom(current.value)
        newNodeRandom.next = current.next
        current.next = newNodeRandom
        current = newNodeRandom.next
    }

    // Step 2: Assign random pointers to copied nodes
    current = head
    while (current != null) {
        current.next?.random = current.random?.next
        current = current.next?.next
    }

    // Step 3: Separate original and copied list
    val newHead = head.next
    var original: NodeRandom? = head
    var copy: NodeRandom? = newHead

    while (original != null) {
        original.next = original.next?.next
        copy?.next = copy?.next?.next
        original = original.next
        copy = copy?.next
    }

    return newHead
}
