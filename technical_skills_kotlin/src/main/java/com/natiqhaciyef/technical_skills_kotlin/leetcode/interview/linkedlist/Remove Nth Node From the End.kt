package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.linkedlist

import com.natiqhaciyef.technical_skills_kotlin.leetcode.easy.ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    // 1st edge case which is null
    if(head == null) return null

    var size = 0
    var current = head
    // find the size of linked list
    while(current != null){
        current = current?.next
        size +=1
    }

    // 2nd edge case - if n higher than size return null
    if(size < n)
        return null

    // 3rd edge case - if size == n  remove first index
    if(size == n)
        return head?.next

    // target equals to (size - n)th number
    current = head
    var counter = 0
    while(current != null && counter < size-n-1){
        current = current?.next
        counter +=1
    }

    current?.next = current?.next?.next
    return head
}