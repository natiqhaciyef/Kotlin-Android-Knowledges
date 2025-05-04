package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun isAnagram(s: String, t: String): Boolean {
    val hashMap = hashMapOf<Char, Int>()
    if (s.length != t.length)
        return false

    for (index in s.indices) {
        if (hashMap.containsKey(s[index]))
            hashMap[s[index]] = hashMap[s[index]]!! + 1
        else
            hashMap[s[index]] = 1
    }

    for (index in t.indices) {
        if (hashMap.containsKey(t[index]))
            hashMap[t[index]] = hashMap[t[index]]!! - 1
        else
            return false
    }


    return hashMap.values.all { it == 0 }
}