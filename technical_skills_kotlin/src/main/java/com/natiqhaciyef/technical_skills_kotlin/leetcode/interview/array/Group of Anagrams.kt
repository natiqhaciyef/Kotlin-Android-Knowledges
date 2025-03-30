package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview.array

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val sortedKey = manualSort(str)  // Sort the string manually

        if (!map.containsKey(sortedKey)) {
            map[sortedKey] = mutableListOf()  // Create a new list if key doesn't exist
        }
        map[sortedKey]!!.add(str)  // Add the word to the corresponding group
    }

    val result = mutableListOf<List<String>>()  // Store the grouped anagrams
    for (entry in map) {
        result.add(entry.value)
    }

    return result
}

// **Manual Bubble Sort for Strings**
fun manualSort(s: String): String {
    val chars = s.toCharArray()
    val n = chars.size

    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (chars[j] > chars[j + 1]) {  // Swap if out of order
                val temp = chars[j]
                chars[j] = chars[j + 1]
                chars[j + 1] = temp
            }
        }
    }

    // Convert sorted char array back to string
    var sortedString = ""
    for (c in chars) {
        sortedString += c
    }

    return sortedString
}

// **Example Usage**
fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(strs))
}
