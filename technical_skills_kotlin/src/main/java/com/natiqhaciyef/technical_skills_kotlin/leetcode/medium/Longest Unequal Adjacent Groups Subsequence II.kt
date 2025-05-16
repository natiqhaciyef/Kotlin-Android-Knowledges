package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import java.util.LinkedList

/**
 * Calculates the Hamming distance between two strings of equal length.
 * The Hamming distance is the number of positions at which the corresponding characters are different.
 *
 * @param s1 The first string.
 * @param s2 The second string.
 * @return The Hamming distance between s1 and s2.
 * Precondition: s1 and s2 must have the same length.
 */
private fun calculateHammingDistance(s1: String, s2: String): Int {
    var distance = 0
    // Assumes s1.length == s2.length, which is checked by the caller logic
    for (i in s1.indices) {
        if (s1[i] != s2[i]) {
            distance++
        }
    }
    return distance
}



/**
 * Finds the longest subsequence of words satisfying the given conditions.
 * Conditions for adjacent words (words[j], words[i]) in the subsequence:
 * 1. groups[j] != groups[i]
 * 2. words[j].length == words[i].length
 * 3. Hamming distance between words[j] and words[i] is 1.
 *
 * @param words Array of strings.
 * @param groups Array of group numbers corresponding to words.
 * @return An array of strings representing the longest ideal subsequence. If multiple, any is returned.
 */
fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    val n = words.size
    if (n == 0) {
        return listOf()
    }

    // longestSubsequenceLengthEndingAt[i] stores the length of the longest ideal subsequence
    // ending with words[i]. Initialized to 1 because each word itself is a subsequence of length 1.
    val longestSubsequenceLengthEndingAt = IntArray(n) { 1 }

    // previousIndexInSubsequence[i] stores the index of the word that comes before words[i]
    // in the longest ideal subsequence ending at words[i]. Initialized to -1 (no predecessor).
    val previousIndexInSubsequence = IntArray(n) { -1 }

    // Fill the DP tables
    for (i in 0 until n) {
        for (j in 0 until i) {
            // Check conditions for words[i] to follow words[j] in an ideal subsequence
            if (words[i].length == words[j].length && // Length must be equal for Hamming distance
                groups[i] != groups[j] &&
                calculateHammingDistance(words[i], words[j]) == 1) {

                // If words[i] can follow words[j], check if this forms a longer subsequence
                if (longestSubsequenceLengthEndingAt[j] + 1 > longestSubsequenceLengthEndingAt[i]) {
                    longestSubsequenceLengthEndingAt[i] = longestSubsequenceLengthEndingAt[j] + 1
                    previousIndexInSubsequence[i] = j
                }
            }
        }
    }

    // Find the end of the overall longest ideal subsequence.
    // Since n > 0, longestSubsequenceLengthEndingAt has elements, all >= 1.
    // So, maxLengthOfIdealSubsequence will be >= 1, and indexOfLastWordInLongestSubsequence will be a valid index.
    var maxLengthOfIdealSubsequence = 1 // Minimum possible length for n > 0
    var indexOfLastWordInLongestSubsequence = 0 // Default to the first element

    for (i in 0 until n) {
        if (longestSubsequenceLengthEndingAt[i] > maxLengthOfIdealSubsequence) {
            maxLengthOfIdealSubsequence = longestSubsequenceLengthEndingAt[i]
            indexOfLastWordInLongestSubsequence = i
        }
    }

    // Reconstruct the longest subsequence using the previousIndexInSubsequence array.
    // Using LinkedList for efficient addFirst operation, then converting to Array.
    val resultList = LinkedList<String>()
    var currentWordIndex = indexOfLastWordInLongestSubsequence

    // Loop to backtrack and build the subsequence in correct order.
    // currentWordIndex is guaranteed to be valid (0 to n-1) because n > 0.
    while (currentWordIndex != -1) {
        resultList.addFirst(words[currentWordIndex])
        currentWordIndex = previousIndexInSubsequence[currentWordIndex]
    }

    return resultList //.toTypedArray()
}