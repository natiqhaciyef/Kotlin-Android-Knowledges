package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

var li = ListNode(5)
var v = li.`val`
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val list = mutableListOf<Int>()
    var step1 = list1
    var step2 = list2
    var node: ListNode? = null

    if (list1 != null && list2 != null) {
        while (step1 != null){
            list.add(step1.`val`)
            step1 = step1.next
        }

        while (step2 != null){
            list.add(step2.`val`)
            step2 = step2.next
        }

        list.sort()
        var count = 0


        while (count < list.size){
            if (node != null){
                val temp = ListNode(node.`val`)
                temp.next = node.next
                node.`val` = list[list.size - 1 - count]
                node.next = temp
            }else{
                node = ListNode(list[list.size - 1 -count])
            }
            count += 1
        }
    } else if(list1 != null && list2 == null){
        while (step1 != null){
            list.add(step1.`val`)
            step1 = step1.next
        }

        list.sort()
        var count = 0

        while (count < list.size){
            if (node != null){
                val temp = ListNode(node.`val`)
                temp.next = node.next
                node.`val` = list[list.size - 1 - count]
                node.next = temp
            }else{
                node = ListNode(list[list.size - 1 -count])
            }
            count += 1
        }
    } else if (list2 != null && list1 == null){
        while (step2 != null){
            list.add(step2.`val`)
            step2 = step2.next
        }

        list.sort()
        var count = 0

        while (count < list.size){
            if (node != null){
                val temp = ListNode(node.`val`)
                temp.next = node.next
                node.`val` = list[list.size - 1 - count]
                node.next = temp
            }else{
                node = ListNode(list[list.size - 1 - count])
            }
            count += 1
        }
    }

    return node
}

fun main() {
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next?.next = ListNode(3)

    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next?.next = ListNode(4)

    mergeTwoLists(list1, list2)
}