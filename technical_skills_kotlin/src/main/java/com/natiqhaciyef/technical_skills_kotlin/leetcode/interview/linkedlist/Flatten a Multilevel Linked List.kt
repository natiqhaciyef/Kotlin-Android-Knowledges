package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.linkedlist

class NodeFlatten(var `val`: Int) {
    var prev: NodeFlatten? = null
    var next: NodeFlatten? = null
    var child: NodeFlatten? = null
}

fun flatten(head: NodeFlatten?): NodeFlatten? {
    if (head == null) return null

    val stack = ArrayDeque<NodeFlatten>()
    var current = head

    while (current != null) {
        if (current.child != null) {
            if (current.next != null) {
                stack.addLast(current.next!!)
            }
            current.next = current.child
            current.next?.prev = current
            current.child = null
        }

        if (current.next == null && stack.isNotEmpty()) {
            current.next = stack.removeLast()
            current.next?.prev = current
        }

        current = current.next
    }

    return head
}