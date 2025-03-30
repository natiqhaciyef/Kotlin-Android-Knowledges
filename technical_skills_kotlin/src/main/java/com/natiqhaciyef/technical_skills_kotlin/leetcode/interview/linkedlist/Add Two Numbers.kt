package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.linkedlist

import com.natiqhaciyef.technical_skills_kotlin.leetcode.easy.ListNode


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummyHead = ListNode(0) // Dummy node to simplify list creation
    var current = dummyHead
    var carry = 0

    var p = l1
    var q = l2

    while (p != null || q != null) {
        val x = p?.`val` ?: 0 // If p is null, use 0
        val y = q?.`val` ?: 0 // If q is null, use 0
        val sum = x + y + carry

        carry = sum / 10 // Carry for next addition
        current.next = ListNode(sum % 10) // Store the last digit in result

        current = current.next!! // Move to next node
        p = p?.next
        q = q?.next
    }

    // If there's a carry left, add a new node
    if (carry > 0) {
        current.next = ListNode(carry)
    }

    return dummyHead.next // Return the result list
}