package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return null
    var current = head
    var resultHead: ListNode? = ListNode(current.`val`) // 5
    current = current.next


    while (current != null) {
        val temp = resultHead
        resultHead = ListNode(current.`val`)
        resultHead.next = temp
        current = current.next
    }
    return resultHead
}