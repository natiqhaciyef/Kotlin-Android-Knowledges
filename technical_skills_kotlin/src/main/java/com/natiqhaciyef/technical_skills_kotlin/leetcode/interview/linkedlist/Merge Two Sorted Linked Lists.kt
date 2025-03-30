package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.linkedlist

import com.natiqhaciyef.technical_skills_kotlin.leetcode.easy.ListNode


fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        list2
    }
}