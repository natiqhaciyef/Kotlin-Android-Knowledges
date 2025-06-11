package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun sortList(head: ListNode?): ListNode? {
    if(head == null) return head

    val list = mutableListOf<Int>()
    var root = head

    while(root != null){
        list.add(root!!.`val`)
        root = root?.next
    }

    val sortedList = mergeSort(list)
    println(sortedList)

    val headResult = ListNode(sortedList[0])
    var customRoot: ListNode? = headResult

    for(i in 1 until sortedList.size){
        customRoot?.next = ListNode(sortedList[i])
        customRoot = customRoot?.next
    }

    return headResult
}

fun mergeSort(list: MutableList<Int>): MutableList<Int> {
    if (list.size <= 1)
        return list

    val half = list.size / 2

    val left = list.subList(0, half).toMutableList()
    val right = list.subList(half, list.size).toMutableList()

    return merge(
        mergeSort(left),
        mergeSort(right)
    )
}

fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int> {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0

    // Merge both lists by comparing elements
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result.add(left[i])
            i++
        } else {
            result.add(right[j])
            j++
        }
    }

    // Add remaining elements from left list
    while (i < left.size) {
        result.add(left[i])
        i++
    }

    // Add remaining elements from right list
    while (j < right.size) {
        result.add(right[j])
        j++
    }

    return result
}

fun main() {
    val head = ListNode(4)
    head.next = ListNode(2)
    head.next?.next = ListNode(1)
    head.next?.next?.next = ListNode(3)

    sortList(head = head)
}