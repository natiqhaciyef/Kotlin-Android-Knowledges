package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


private val list = mutableSetOf<String>()

fun findEvenNumbers(digits: IntArray): IntArray {
    // Topics: HashMap, Sorting, Enumeration, Array
    val map = mutableMapOf<Int, Int>()

    // Calculate how many characters do we have
    for (digit in digits) {
        map[digit] = map.getOrDefault(digit, 0) + 1
    }

    // main operation
    backtrack(digits, 0, "", map)

    val result = mutableListOf<Int>()

    // mapping and filtering for the exact result
    for (s in list) {
        var num = s.toInt()
        if (num % 2 == 0)
            result.add(num)
    }

    // I don't use sorting from scratch :D
    result.sort()

    return result.toIntArray()
}

fun backtrack(digits: IntArray, index: Int, num: String, visited: MutableMap<Int, Int>) {
    // if length == 3 which means num between 100..999
    if (num.length == 3) {
        // but we should handle numbers which starts with 0
        if (num[0] != '0')
            list.add(num)
        return
    }

    // if index out of bound return and don't operate something
    if (index >= digits.size)
        return

    var current = 0
    while (current < digits.size) {
        val digit = digits[current]

        // if we haven't any remained number which means digit already used and there is no more digit
        // we should continue
        if (visited[digit]!! <= 0) {
            current += 1
            continue
        }

        // we add digit to num so we should decrease count of digits
        visited[digit] = visited[digit]!! - 1
        backtrack(digits, current, num + digit, visited)

        // then we increase again
        // Why? because we decreased it for next operations (for next backtracking on above)
        // We should restore same number because we using loop every loop should contains correct
        // inputs => visited used in previous loop it should not affect to next loop or current loop
        visited[digit] = visited[digit]!! + 1
        current += 1
    }
}
