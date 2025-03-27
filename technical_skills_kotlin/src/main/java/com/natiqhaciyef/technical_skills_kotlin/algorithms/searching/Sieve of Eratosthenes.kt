package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

fun countPrimes(n: Int): Int {
    if (n <= 2) return 0

    val isPrime = BooleanArray(n) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2 until n) {
        if (isPrime[i]) {
            var multiple = 2 * i
            while (multiple < n) {
                isPrime[multiple] = false
                multiple += i
            }
        }
    }

    return isPrime.count { it }
}