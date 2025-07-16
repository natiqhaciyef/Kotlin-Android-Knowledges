package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

/**
 * Calculates the length of the longest valid subsequence.
 *
 * A subsequence is valid if the parity of the sum of its adjacent elements is constant.
 * This implies four possible patterns for the subsequence's parities:
 * 1. All elements are even.
 * 2. All elements are odd.
 * 3. Alternating parity, starting with an even number.
 * 4. Alternating parity, starting with an odd number.
 *
 * The function computes the longest possible length for each of these four scenarios
 * and returns the maximum value.
 *
 * @param nums The input integer array.
 * @return The length of the longest valid subsequence.
 */
fun maximumLength(nums: IntArray): Int {
    // Case 1 & 2: All elements have the same parity (all even or all odd).
    // The length is the total count of even or odd numbers.
    val countEven = nums.count { it % 2 == 0 }
    val countOdd = nums.size - countEven

    // Case 3 & 4: Elements have alternating parities.
    // We find the lengths for both starting patterns (even-odd and odd-even)
    // in a single pass.
    var lenAltStartEven = 0
    var expectedParityEven = 0 // 0 for even
    var lenAltStartOdd = 0
    var expectedParityOdd = 1 // 1 for odd

    for (num in nums) {
        val parity = num % 2

        // Check for pattern starting with even: even, odd, even, ...
        if (parity == expectedParityEven) {
            lenAltStartEven++
            expectedParityEven = 1 - expectedParityEven // Flip expected parity
        }

        // Check for pattern starting with odd: odd, even, odd, ...
        if (parity == expectedParityOdd) {
            lenAltStartOdd++
            expectedParityOdd = 1 - expectedParityOdd // Flip expected parity
        }
    }

    // The result is the maximum length found among the four cases.
    return maxOf(countEven, countOdd, lenAltStartEven, lenAltStartOdd)
}