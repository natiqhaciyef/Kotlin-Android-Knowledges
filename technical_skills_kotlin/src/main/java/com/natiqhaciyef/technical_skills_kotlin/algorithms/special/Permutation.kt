package com.natiqhaciyef.technical_skills_kotlin.algorithms.special

private fun permute(chars: CharArray, index: Int, result: MutableList<String>) {
    if (index == chars.size - 1) {
        result.add(String(chars))
        println("result => $result")
        return
    }

    val seen = mutableSetOf<Char>()

    for (i in index until chars.size) {
        if (chars[i] in seen) continue

        seen.add(chars[i])
        println("chars init => ${chars.toMutableList()}")
        println("index => $index")

        // Swap chars[index] and chars[i] without an extension function
        val temp = chars[index]
        chars[index] = chars[i]
        chars[i] = temp

        println("chars => ${chars.toMutableList()}")
        permute(chars, index + 1, result)

        // Backtrack
        val tempBack = chars[index]
        chars[index] = chars[i]
        chars[i] = tempBack

        println("chars backing => ${chars.toMutableList()}")

        println("------------")
    }
}

fun subsets(input: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun backtrack(index: Int, current: List<Int>) {
        if (index == input.size) {
            result.add(current)
            return
        }
        backtrack(index + 1, current)                      // Exclude input[index]
        backtrack(index + 1, current + input[index])       // Include input[index]
    }

    backtrack(0, listOf())
    return result
}
