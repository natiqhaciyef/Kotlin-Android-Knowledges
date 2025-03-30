package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.linkedlist

import com.natiqhaciyef.technical_skills_kotlin.leetcode.easy.ListNode


fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null

    var pA = headA
    var pB = headB

    // 3- 5- 6- 7- 8- 11- 100 // 2-7-9-11-100
    // 2-7-9-11-100 // 3- 5- 6- 7- 8- 11- 100

    while (pA != pB) {
        pA = if (pA == null) headB else pA.next
        pB = if (pB == null) headA else pB.next
    }

    return pA
}