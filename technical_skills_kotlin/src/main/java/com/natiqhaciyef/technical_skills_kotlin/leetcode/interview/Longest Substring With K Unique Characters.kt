package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun longestSubstringWorst(str: String, k: Int): Int {
    if (str.isEmpty()) return 0
    val subsSet = mutableSetOf<String>()

    var index = 0
    var uniques = 0
    var uniqueIndex = 0
    var temp = ""

    // 1
    while (index < str.length) {
        // aa bb cc
        if (temp.isNotEmpty() && !temp.contains(str[index])) {
            uniques += 1

            if (uniques != k)
                uniqueIndex = index
        }

        // aabbcc
        if (uniques == k && index > 0) {
            if (str[index] == str[index - 1])
                temp += str[index]
            else {
                subsSet.add(temp)
                temp = ""
                index = uniqueIndex - k + 1
                uniques = 0
            }
        } else
            temp += str[index]

        if (index == str.length - 1) {
            subsSet.add(temp)
        }

        index++
    }

    temp = subsSet.first()
    for (element in subsSet) {
        if (element.length > temp.length)
            temp = element

    }
    println(subsSet.toList())
    println("Result: ${temp.length}")
    return temp.length
}


fun longestSubstring(str: String, k: Int): Int {
    if (str.isEmpty() || k == 0) return 0

    val charCount = mutableMapOf<Char, Int>()
    var left = 0
    var maxLength = 0

    for (right in str.indices) {
        charCount[str[right]] = charCount.getOrDefault(str[right], 0) + 1
        println("Char right: ${str[right]}")

        // Shrink window if unique characters exceed `k`
        while (charCount.size > k) {
            charCount[str[left]] = charCount[str[left]]!! - 1
            println("Char left: ${str[left]}")

            if (charCount[str[left]] == 0) charCount.remove(str[left])
            left++

            println("Left: $left")
        }

        // Update maxLength if we have exactly `k` unique characters
        if (charCount.size == k) {
            maxLength = maxOf(maxLength, right - left + 1)
            println("Max: $maxLength")
        }
    }

    return maxLength
}

fun main() {
    println(longestSubstringWorst("aaaaaaa", 1))     // ✅ Expected: 7
    println(longestSubstringWorst("abababab", 2))    // ✅ Expected: 8
    println(longestSubstringWorst("aabbcc", 2))      // ✅ Expected: 4
    println(longestSubstringWorst("aabbcc", 3))      // ✅ Expected: 6
    println(longestSubstringWorst("aabbcc", 4))      // ✅ Expected: 0 (Not enough unique characters)
    println(longestSubstringWorst("abcabcabcabc", 3)) // ✅ Expected: 12
    println(longestSubstringWorst("abcadcacacaca", 3)) // ✅ Expected: 11
}