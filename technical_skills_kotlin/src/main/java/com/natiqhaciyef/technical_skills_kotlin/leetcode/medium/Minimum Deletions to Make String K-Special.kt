package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import kotlin.math.abs


/** Helpful
 * Hint 4
 * Then, for every other character, we will count the number of occurrences that will be deleted.
 * Suppose that the current character has y occurrences.
 *
 * If y < x, we need to delete all of them.
 * if y > x + k, we should delete y - x - k of such character.
 * Otherwise we don’t need to delete it.
 * */

fun minimumDeletions(word: String, k: Int): Int {
    // Inputs: String, Int
    // Topic: HashMap, String, Greedy, Sorting, Counting

    // we should create frequency hashtable
    // find overbound pairs
    // decrease values of overbound char

    // Note: We can only delete not add

    val freq = mutableMapOf<Char, Int>()

    for (ch in word) {
        freq[ch] = freq.getOrDefault(ch, 0) + 1
    }

    // aabcaba
    // f => 2
    // p => 3
    // z => 6

    // count of the over limit
    var result = Int.MAX_VALUE

    for ((key1, value1) in freq) {
        var changes = 0
        val nPivot = value1 + k


        for ((key2, value2) in freq) {
            if (key1 == key2) continue

            changes += if (value1 > value2) {
                value2
            } else if (nPivot < value2) {
                value2 - nPivot
            } else {
                0
            }
        }

        result = minOf(result, changes)
    }

    println(freq)
    println(result)

    return result
}

fun main() {
//    minimumDeletions("aabcaba", 0)
//    minimumDeletions("dabdcbdcdcd", 2)
//    minimumDeletions("aaabaaa", 2)
//    minimumDeletions("vvnowvov", 2)
    minimumDeletions("zzfzzzzppfp", 1)
//    minimumDeletions("aabcaba", 1)
}