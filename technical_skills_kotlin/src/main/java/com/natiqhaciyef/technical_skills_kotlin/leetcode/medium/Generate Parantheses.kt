package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


val storage = mutableListOf<String>()

fun generateParenthesis(n: Int): List<String> {
    recursionParenthesis(n*2)

    val result = storage.filter {
        isValid(it)
    }

    return result
}

fun isValid(str: String): Boolean {
    var countCorrect = 0

    if (str.startsWith(")") || str.endsWith("("))
        return false



    for (ch in str) {
        if (ch == '(')
            countCorrect += 1
        else
            countCorrect -= 1

        if (countCorrect == -1)
            return false
    }

    return countCorrect == 0
}

fun recursionParenthesis(count: Int, current: String = "") {
    if (current.length == count) {
        storage.add(current)
        return
    }


    recursionParenthesis(count, current + "(")
    recursionParenthesis(count, current + ")")
}


//example
fun generateBinaryStrings(n: Int, current: String = "") {
    if (current.length == n) {
        println(current) // Print the generated string
        return
    }

    // Add '0' and recurse
    generateBinaryStrings(n, current + "0")

    // Add '1' and recurse
    generateBinaryStrings(n, current + "1")
}

fun main() {
    println(generateParenthesis(3))
//    generateBinaryStrings(3)
}
