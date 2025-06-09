package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

fun findKthNumber(n: Int, k: Int): Int {
    // Topics: Trie

    var curr = 1
    var kLeft = k - 1L

    // starts from end to find the correct row of number
    while (kLeft > 0) {
        val steps = countSteps(curr.toLong(), n.toLong())

        if (steps <= kLeft) {
            curr += 1
            kLeft -= steps
        } else {
            // in here it means number between current steps => in curr
            // Example
            // searched number starts with 1
            // so we search only numbers which start with 1

            curr *= 10
            // due to visiting new node like in trie
            // we decreasing kLeft by 1 because
            // Example
            // curr changes => 1 to 10 and it means switches single node
            // so we remove single node change from the kLeft
            kLeft -= 1
        }
    }
    return curr
}

private fun countSteps(curr: Long, n: Long): Long {
    var steps = 0L
    var first = curr
    var last = curr


    // Increases bound of start and end of current i
    // i = 1
    // it goes to 10..19, 100..199, 1000..1999 and so on.
    while (first <= n) {
        steps += minOf(last, n) - first + 1
        first *= 10
        last = last * 10 + 9
    }
    return steps
}


fun main() {
    val result = findKthNumber(4289384, 1922239)
    println(result)
}