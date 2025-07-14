package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

import kotlin.math.pow

fun getDecimalValue(head: ListNode?): Int {
    // Topics: Linked List, Math

    val arr = mutableListOf<Int>()
    var temp = head

    while(temp != null){
        temp.let { arr.add(it.`val`) }
        temp = temp.next
    }

    var result = 0.0
    for(i in arr.size - 1 downTo 0){
        result += arr[i] * 2.0.pow(arr.size - i - 1)
    }

    return result.toInt()
}