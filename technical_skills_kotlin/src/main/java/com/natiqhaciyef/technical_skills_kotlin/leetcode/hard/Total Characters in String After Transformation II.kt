package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

private val MOD = 1_000_000_007

// Helper function for matrix multiplication: C = A * B
// All matrix elements are integers modulo MOD.
private fun multiplyMatrices(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    val n = arr1.size // Assuming square matrices of size 26
    val result = Array(n) { IntArray(n) } // Initialize with zeros

    for (r in 0 until n) {
        for (c in 0 until n) {
            var sumVal = 0L // Use Long for sum to prevent overflow during summation of products
            for (k in 0 until n) {
                // A[r][k] and B[k][c] are Ints (mod MOD).
                // Their product can be up to (MOD-1)*(MOD-1), which fits in Long.
                val termLong = arr1[r][k].toLong() * arr2[k][c].toLong()
                sumVal = (sumVal + termLong) % MOD
            }
            result[r][c] = sumVal.toInt()
        }
    }
    return result
}

// Helper function for matrix exponentiation: result = base^exp
private fun matrixPower(base: Array<IntArray>, exp: Int): Array<IntArray> {
    val n = base.size
    var resultMatrix = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        resultMatrix[i][i] = 1 // Start with identity matrix
    }

    // Use a copy of base for iterative squaring
    var currentPower = base.map { it.clone() }.toTypedArray()
    var e = exp

    while (e > 0) {
        if (e % 2 == 1) { // If exp is odd, multiply by current base power
            resultMatrix = multiplyMatrices(resultMatrix, currentPower)
        }
        // Square the current base power
        currentPower = multiplyMatrices(currentPower, currentPower)
        e /= 2 // Halve the exponent
    }
    return resultMatrix
}

fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Long {
    // Edge case: if t=0, no transformations occur, length is s.length.
    if (t == 0) {
        return s.length.toLong()
    }

    // 1. Initialize v0 (initial character counts vector from string s)
    val v0 = IntArray(26)
    for (char in s) {
        v0[char - 'a']++
    }

    // 2. Construct the transformation matrix T
    val matrix = Array(26) { IntArray(26) } // Initialize with zeros
    for (j in 0 until 26) { // j is the source character index (0 for 'a', ...)
        val numCharsToGenerate = nums[j] // Number of characters s[i] expands into

        // Calculate full alphabet cycles and remaining characters
        val numFullCycles = numCharsToGenerate / 26
        val numRemainingChars = numCharsToGenerate % 26

        // Add contributions from full cycles
        // Each full cycle adds 1 to the count of every character produced from char j
        if (numFullCycles > 0) {
            for (i in 0 until 26) { // i is the target character index
                // T[i][j] is number of char i's produced by one char j
                matrix[i][j] = ((matrix[i][j].toLong() + numFullCycles.toLong()) % MOD).toInt()
            }
        }

        // Add contributions from remaining characters
        // These are (j+1)%26, (j+2)%26, ..., (j+numRemainingChars)%26
        for (k in 1..numRemainingChars) {
            val targetCharIdx = (j + k) % 26
            matrix[targetCharIdx][j] = ((matrix[targetCharIdx][j].toLong() + 1L) % MOD).toInt()
        }
    }

    // 3. Compute T_pow_t = T^t using matrix exponentiation
    val tPowT = matrixPower(matrix, t)

    // 4. Compute final counts vector v_t = T_pow_t * v0
    val vect = LongArray(26) // Final counts can be large, store as Long
    for (i in 0 until 26) { // For each character type i in the resulting string
        var sumValCharI = 0L
        for (j in 0 until 26) { // Sum contributions from initial characters j
            // (T_pow_t[i][j] * v0[j]) is how many char i's result from all initial char j's
            val term = tPowT[i][j].toLong() * v0[j].toLong()
            sumValCharI = (sumValCharI + term) % MOD
        }
        vect[i] = sumValCharI
    }

    // 5. Calculate total length by summing all character counts in v_t
    var totalLength = 0L
    for (count in vect) {
        totalLength = (totalLength + count) % MOD
    }

    // Ensure the result is non-negative (Kotlin's % on positive numbers is positive).
    return totalLength
}


// Solution of mine
fun lengthAfterTransformationsWorst(s: String, t: Int, nums: List<Int>): Long {
    // Topics: HashMap, Math, String, Dynamic Programming, Counting

    // Topics: HashTable, Math, String, Dynamic Programming, Counting
    // if char == 'z' -> replace with "ab"
    // so count of the char + t > 'z' count += 1


    val map = mutableMapOf<Int, Int>()
    var current = 0

    for (char in s) {
        val dig = findDigitOfChar(char)
        map[dig] = map.getOrDefault(dig, 0) + 1
    }
    // println("map = $map")

    // [y to 2. x to 3]
    // [z to 2, y to 3]
    // [a to 2, b to 2, z to 3]
    // [a to 3, b to 5, c to 3]

    while (current < t) {
        // println("before change map => ${map.keys}")

        val newMap = mutableMapOf<Int, Int>()

        for ((key, temp) in map) {
            val newKey = key + nums[key]
            var currentCounter = key + 1

            while (currentCounter <= newKey) {
                newMap[currentCounter % 26] =
                    (newMap.getOrDefault(currentCounter % 26, 0) + temp) % MOD

                // println("New => $newMap")
                currentCounter += 1
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
    return char - 'a' //+ 1
}