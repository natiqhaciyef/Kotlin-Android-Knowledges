package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


private val MOD = 1_000_000_007
fun lengthAfterTransformations(s: String, t: Int): Long {
    // Topics: HashTable, Math, String, Dynamic Programming, Counting
    // if char == 'z' -> replace with "ab"
    // so count of the char + t > 'z' count += 1


    val map = mutableMapOf<Int, Int>()
    var current = 0

    for (char in s) {
        val dig = findDigitOfChar(char)
        map[dig] = map.getOrDefault(dig, 0) + 1
    }

    // [y to 2. x to 3]
    // [z to 2, y to 3]
    // [a to 2, b to 2, z to 3]
    // [a to 3, b to 5, c to 3]

    val bound = findDigitOfChar('z')

    while (current < t) {
        // println("before change map => ${map.keys}")

        val newMap = mutableMapOf<Int, Int>()

        for ((key, temp) in map) {
            if (key == bound) {
                newMap[1] = (newMap.getOrDefault(1, 0) + temp) % MOD
                newMap[2] = (newMap.getOrDefault(2, 0) + temp) % MOD
            } else {
                newMap[key + 1] = (newMap.getOrDefault(key + 1, 0) + temp) % MOD
            }
        }

        map.clear()
        map.putAll(newMap)

        // println("changed map => $map")
        current += 1
    }


    var result = 0L
    for (value in map.values) {
        result = (result + value) % MOD
    }

    return result
}

fun findDigitOfChar(char: Char): Int {
    return char - 'a' + 1
}

fun main() {
    println(lengthAfterTransformations("abcyy", 2))
}