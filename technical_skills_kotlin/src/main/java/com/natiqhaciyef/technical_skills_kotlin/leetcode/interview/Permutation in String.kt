package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview


fun checkInclusionWorst(s1: String, s2: String): Boolean {
    var window = s2.substring(0, s1.length)
    var temp = s1.toMutableList()

    println("Window: $window")
    println("Temp: $temp")
    for(ch in window){
        if(temp.contains(ch))
            temp.remove(ch)
    }

    if(temp.isEmpty())
        return true
    else
        temp = s1.toMutableList()

    for(i in s1.length until s2.length){
        window += s2[i]
        window = window.removeRange(0..0)

        println("Window: $window")
        println("Temp: $temp")

        for(ch in window){
            if(temp.contains(ch))
                temp.remove(ch)
        }

        if(temp.isEmpty())
            return true
        else
            temp = s1.toMutableList()
    }

    return false
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false

    val countS1 = IntArray(26)
    val countS2 = IntArray(26)

    // Fill frequency array for s1 and the first window of s2
    for (i in s1.indices) {
        countS1[s1[i] - 'a']++
        countS2[s2[i] - 'a']++
    }


    // Function to compare character counts
    fun matches(): Boolean = countS1.contentEquals(countS2)

    // Check first window
    if (matches()) return true

    // Slide the window
    for (i in s1.length until s2.length) {
        countS2[s2[i] - 'a']++       // Add new character to window
        countS2[s2[i - s1.length] - 'a']-- // Remove old character

        if (matches()) return true
    }

    return false
}

fun main() {
//    println(checkInclusion("adc", "dcda"))
    println(checkInclusionWorst("ab", "eidboaoo"))
//    val map = mutableMapOf('c' to 1)
//    map['c'] = map.getOrDefault('c', 0) + 1
//    map.values.all { it == 0 }
}