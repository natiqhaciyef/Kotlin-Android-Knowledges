package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

import com.natiqhaciyef.technical_skills_kotlin.leetcode.medium.ListNode

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    var node = head

    while(node?.next != null){
        val value = node.next?.`val`

        if(value == `val`){
            node.next = node.next?.next

            continue
        }

        node = node.next
    }

    if(head?.`val` == `val`)
        return head.next

    return head
}