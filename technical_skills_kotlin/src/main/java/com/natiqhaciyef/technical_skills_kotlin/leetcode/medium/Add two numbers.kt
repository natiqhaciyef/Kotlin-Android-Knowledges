package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

var li = ListNode(5)
var v = li.`val`

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var carry = 0
    var dummy = ListNode(0)
    var current = dummy
    var p = l1
    var q = l2

    while (p != null || q != null) {
        val x = p?.`val` ?: 0
        val y = q?.`val` ?: 0
        val sum = x + y + carry
        carry = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!

        if (p != null) p = p.next
        if (q != null) q = q.next
    }

    if (carry > 0) {
        current.next = ListNode(carry)
    }

    return dummy.next
}
fun main() {
    val l1 = ListNode(`val` = 2)
    l1.next = ListNode(`val` = 4)
    l1.next!!.next = ListNode(`val` = 3)

    val l2 = ListNode(`val` = 5)
    l2.next = ListNode(`val` = 6)
    l2.next!!.next = ListNode(`val` = 4)

    val l3 = ListNode(9)
    val l4 = ListNode(1) //1,9,9,9,9,9,9,9,9,9
    l4.next = ListNode(9)
    l4.next!!.next = ListNode(9)
    l4.next!!.next!!.next = ListNode(9)
    l4.next!!.next!!.next!!.next = ListNode(9)
    l4.next!!.next!!.next!!.next!!.next = ListNode(9)
    l4.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)
    l4.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)
    l4.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)
    l4.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)


    val result = addTwoNumbers(l1 = l3, l2 = l4)
    println(result?.`val`)
    println(result?.next?.`val`)
}