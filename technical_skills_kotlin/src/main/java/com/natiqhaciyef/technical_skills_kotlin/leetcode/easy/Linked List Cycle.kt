package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun hasCycle(head: ListNode?): Boolean {
    if(head?.next == null) return false
    val collectedNodes = mutableMapOf<ListNode, Boolean>()

    var current = head
    while(current != null){
        collectedNodes[current] = true
        current = current.next

        if(collectedNodes[current] == true)
            return true
    }

    return false
}