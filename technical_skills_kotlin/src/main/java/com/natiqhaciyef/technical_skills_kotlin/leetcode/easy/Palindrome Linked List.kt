package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun isPalindrome(head: ListNode?): Boolean {
    val list = mutableListOf<Int>()

    var current = head
    while(current != null){
        list.add(current.`val`)
        current = current.next
    }

    val midIndex = list.size/2
    for(i in 0 .. midIndex){
        if(list[i] != list[list.size-1-i])
            return false
    }

    return true
}