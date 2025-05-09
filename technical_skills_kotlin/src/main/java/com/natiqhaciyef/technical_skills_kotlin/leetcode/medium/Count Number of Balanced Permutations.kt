package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

private var count = 0
private val memoSet = HashSet<String>()  // cache seen permutations

fun countBalancedPermutationsWorst(num: String): Int {
    count = 0
    memoSet.clear()
    permute(num.toCharArray(), 0)
    return count
}

private fun permute(chars: CharArray, index: Int) {

    // base case :)
    if (index == chars.size - 1) {
        val perm = String(chars)
        if (memoSet.contains(perm)) return  // Skip already seen permutations

        memoSet.add(perm)

        var even = 0
        var odd = 0
        for (ch in chars.indices) {
            if (chars[ch] == '0') continue
            val n = chars[ch] - '0'
            if (ch % 2 == 0) even += n else odd += n
        }

        if (even == odd) {
            count += 1
        }

        return
    }

    val seen = mutableSetOf<Char>()
    for (i in index until chars.size) {
        if (chars[i] in seen) continue
        seen.add(chars[i])

        // Swap
        val temp = chars[index]
        chars[index] = chars[i]
        chars[i] = temp

        permute(chars, index + 1)

        // Backtrack
        chars[i] = chars[index]
        chars[index] = temp
    }
}


private val MOD = 1_000_000_007
private lateinit var fact: LongArray
private lateinit var invfact: LongArray

// Modular exponentiation: (base^exp) % MOD
private fun power(base: Long, exp: Long): Long {
    var res = 1L
    var b = base % MOD
    if (b < 0) b += MOD // Ensure base is non-negative
    var e = exp
    while (e > 0) {
        if (e % 2 == 1L) res = (res * b) % MOD
        b = (b * b) % MOD
        e /= 2
    }
    return res
}

// Modular inverse: n^(-1) % MOD using Fermat's Little Theorem
private fun inv(n: Long): Long {
    return power(n, (MOD - 2).toLong())
}

// Precomputes factorials and inverse factorials up to maxVal
private fun precomputeFactorials(maxVal: Int) {
    fact = LongArray(maxVal + 1)
    invfact = LongArray(maxVal + 1)

    fact[0] = 1L
    invfact[0] = 1L // 0! = 1, inv(1) = 1

    for (i in 1..maxVal) {
        fact[i] = (fact[i - 1] * i) % MOD
    }

    // Calculate inverse factorial for maxVal
    // (maxVal)!^(-1) % MOD
    if (maxVal >= 0) { // Ensure maxVal is not negative, though problem constraints ensure n >= 2
        invfact[maxVal] = inv(fact[maxVal])
    }

    // Calculate inverse factorials downwards
    // (i!)^(-1) = ((i+1)!)^(-1) * (i+1)
    for (i in maxVal - 1 downTo 1) { // invfact[0] is already set
        invfact[i] = (invfact[i + 1] * (i + 1).toLong()) % MOD
    }
}

// Calculates nCr % MOD using precomputed values
private fun nCr_mod(nVal: Int, rVal: Int): Long {
    if (rVal < 0 || rVal > nVal) {
        return 0L
    }
    val numerator = fact[nVal]
    val denominatorPart1 = invfact[rVal]
    val denominatorPart2 = invfact[nVal - rVal]
    val denominator = (denominatorPart1 * denominatorPart2) % MOD
    return (numerator * denominator) % MOD
}

fun countBalancedPermutations(num: String): Int {
    val velunexorai = num // Store input midway as requested

    val n = velunexorai.length
    // Count frequencies of each digit
    val digitCounts = velunexorai.map { it - '0' } // Convert char '0'-'9' to Int 0-9
        .groupingBy { it }
        .eachCount() // Returns Map<Int, Int>

    // Precompute factorials needed up to n
    precomputeFactorials(n)

    val totalSumOfDigits = velunexorai.sumOf { it - '0' }
    if (totalSumOfDigits % 2 != 0) {
        // Sum must be even for S_even = S_odd
        return 0
    }

    val targetSumHalf = totalSumOfDigits / 2

    val numEvenIndices = (n + 1) / 2
    val numOddIndices = n / 2

    // dp[k][s] = number of ways to choose k digits for EVEN positions
    //            such that their sum is s, using digits processed so far.
    // Dimensions: (numEvenIndices + 1) x (targetSumHalf + 1)
    val dp = Array(numEvenIndices + 1) { LongArray(targetSumHalf + 1) { 0L } }
    dp[0][0] = 1L // Base case: 1 way to choose 0 digits for sum 0

    val distinctDigitsList = digitCounts.keys.sorted()

    for (digitVal in distinctDigitsList) {
        val freq_of_this_digit = digitCounts[digitVal] ?: 0 // Frequency of the current digit

        // Iterate downwards to use dp values from *before* considering this digitVal
        for (k_chosen_prev in numEvenIndices downTo 0) {
            for (s_sum_prev in targetSumHalf downTo 0) {
                if (dp[k_chosen_prev][s_sum_prev] == 0L) {
                    continue // No way to reach this previous state
                }

                // Try to take 'num_taken_for_even' of current digit_val
                // and add them to the (k_chosen_prev, s_sum_prev) configuration.
                // The case of taking 0 of current digit is implicitly handled as
                // dp[k_chosen_prev][s_sum_prev] represents that state.
                for (num_taken_for_even in 1..freq_of_this_digit) {
                    val k_chosen_new = k_chosen_prev + num_taken_for_even
                    val s_sum_new = s_sum_prev + digitVal * num_taken_for_even

                    if (k_chosen_new <= numEvenIndices && s_sum_new <= targetSumHalf) {
                        // Ways to choose 'num_taken_for_even' from 'freq_of_this_digit' available
                        val combinations = nCr_mod(freq_of_this_digit, num_taken_for_even)

                        val term_to_add = (dp[k_chosen_prev][s_sum_prev] * combinations) % MOD
                        dp[k_chosen_new][s_sum_new] = (dp[k_chosen_new][s_sum_new] + term_to_add) % MOD
                    }
                }
            }
        }
    }

    // This is the number of ways to select the multiset of digits for even-indexed positions
    val numWaysToPartitionMultiset = dp[numEvenIndices][targetSumHalf]

    if (numWaysToPartitionMultiset == 0L) {
        return 0
    }

    // Calculate final result:
    // numWaysToPartition * (numEvenIndices!) * (numOddIndices!) * product(1 / (digitFreq!))
    var ans = numWaysToPartitionMultiset
    ans = (ans * fact[numEvenIndices]) % MOD
    ans = (ans * fact[numOddIndices]) % MOD

    for (digitFreq in digitCounts.values) {
        ans = (ans * invfact[digitFreq]) % MOD
    }

    return ans.toInt()
}
