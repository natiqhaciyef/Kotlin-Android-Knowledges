package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null

    var pA = headA
    var pB = headB

    while (pA != pB) {
        pA = if (pA == null) headB else pA.next
        pB = if (pB == null) headA else pB.next
    }

    return pA
}
