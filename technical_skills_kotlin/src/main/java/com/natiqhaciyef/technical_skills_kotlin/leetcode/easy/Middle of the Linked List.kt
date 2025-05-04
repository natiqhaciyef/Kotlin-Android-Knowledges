package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun middleNode(head: ListNode?): ListNode? {
    // 1st edge case - if head == null
    if(head == null) return null

    // find the size of the linked list
    var size = 0
    var current = head
    while(current != null){
        current = current?.next
        size += 1
    }

    val mid = size/2
    size = 0
    current = head
    while(current != null && size < mid){
        current = current?.next
        size += 1
    }

    return current
}