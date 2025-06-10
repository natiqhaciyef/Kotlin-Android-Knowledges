package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun maxDifference(s: String): Int {
    val map = mutableMapOf<Char, Int>()

    for (ch in s) {
        map[ch] = map.getOrDefault(ch, 0) + 1
    }

    var oddMax = 0
    var evenMin = -1

    for (value in map.values) {
        if (value % 2 == 1) {
            // odd
            if (oddMax < value)
                oddMax = value

        }else{
            if (evenMin == -1 || evenMin >= value)
                evenMin = value
        }
    }

    return oddMax - evenMin
}