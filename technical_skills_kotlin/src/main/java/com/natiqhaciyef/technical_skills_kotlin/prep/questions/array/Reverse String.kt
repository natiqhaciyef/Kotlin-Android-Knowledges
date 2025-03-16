package com.natiqhaciyef.technical_skills_kotlin.prep.questions.array


fun reverseString(str: String): String {
    if (str.isEmpty() || str.length == 1) return str

    var result = ""
    for (i in str.indices) {
        result += str[str.length - i - 1]
    }
    return result
}

fun main() {
    val arr1 = intArrayOf(1, 2, 4, 5, 6, 7)
    val arr2 = intArrayOf(-2, 1)

}
