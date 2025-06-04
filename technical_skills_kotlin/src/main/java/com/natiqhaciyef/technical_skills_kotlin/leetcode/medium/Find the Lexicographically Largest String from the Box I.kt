package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

import kotlin.math.max
import kotlin.math.min


// Gets TLE Exception
fun answerStringStandard(word: String, numFriends: Int): String {
    if (numFriends <= 1) return word
    val target = word.length - numFriends + 1
    if (target <= 0) return ""

    var high = 0
    var result = ""

    for (i in 0 until numFriends) {
        var longest = ""
        var j = i

        // Build up longest substring within range
        while (j < i + target && j < word.length) {
            longest += word[j]
            val maxOf = longest[0] - 'a'
            if (high < maxOf || (high == maxOf && longest > result)) {
                high = maxOf
                result = longest
            }
            j++
        }

        // Remove characters from start to find other possible substrings
        while (longest.isNotEmpty()) {
            val maxOf = longest[0] - 'a'
            if (high < maxOf || (high == maxOf && longest > result)) {
                high = maxOf
                result = longest
            }
            longest = longest.substring(1)
        }
    }

    return result
}

// Gemini Pro Optimization
fun answerString(word: String, numFriends: Int): String {
    val n = word.length

    // Constraints: 1 <= word.length, 1 <= numFriends <= word.length
    // These ensure n >= 1.

    if (numFriends == 1) {
        return word
    }

    // Calculate the maximum allowed length for any single part in a valid split.
    // This is word.length - (minimum characters needed for other numFriends-1 parts)
    // = n - (numFriends - 1) * 1
    val maxAllowedLength = n - numFriends + 1

    // Since n >= numFriends (given constraint), n - numFriends >= 0.
    // So, maxAllowedLength = (n - numFriends) + 1 >= 0 + 1 = 1.
    // Thus, maxAllowedLength is always at least 1.

    var lexicographicallyLargest = ""

    // Iterate through all N possible starting indices (i) for candidate substrings.
    // For each starting index i, the candidate is the longest possible substring
    // starting at i, with length up to maxAllowedLength.
    for (i in 0 until n) {
        // Calculate the exclusive end index for the candidate substring.
        // The length of word.substring(i, endIndexExclusive) is (endIndexExclusive - i).
        // This length will be min(maxAllowedLength, n - i).
        val endIndexExclusive = min(i + maxAllowedLength, n)

        // The candidate substring is word[i ... endIndexExclusive-1].
        // Since maxAllowedLength >= 1 and i < n:
        //   - If i + maxAllowedLength <= n, then endIndexExclusive = i + maxAllowedLength. Length is maxAllowedLength >= 1.
        //   - If i + maxAllowedLength > n, then endIndexExclusive = n. Length is n - i >= 1 (as i < n).
        // So, a non-empty candidate is always formed.
        val candidate = word.substring(i, endIndexExclusive)

        if (lexicographicallyLargest.isEmpty() || candidate > lexicographicallyLargest) {
            lexicographicallyLargest = candidate
        }
    }

    // If word is non-empty (guaranteed by constraints) and maxAllowedLength >= 1,
    // the loop will execute at least once and find a non-empty candidate.
    // Thus, lexicographicallyLargest will be non-empty.
    return lexicographicallyLargest
}