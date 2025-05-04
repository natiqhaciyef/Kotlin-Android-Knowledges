package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val hashMap = hashMapOf<Char, Int>()

    for (element in ransomNote) {
        if (hashMap.containsKey(element))
            hashMap[element] = hashMap[element]!! + 1
        else
            hashMap[element] = 1
    }

    for (letter in magazine) {
        if (hashMap.containsKey(letter))
            hashMap[letter] = hashMap[letter]!! - 1
    }

    return hashMap.values.all { it <= 0 }
}
