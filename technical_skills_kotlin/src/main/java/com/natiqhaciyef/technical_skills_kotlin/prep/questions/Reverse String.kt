package com.natiqhaciyef.technical_skills_kotlin.prep.questions


fun reverseString(str: String): String {
    if (str.isEmpty() || str.length == 1) return str

    var result = ""
    for (i in str.indices) {
        result += str[str.length - i - 1]
    }
    return result
}

fun main() {
    val str = "almabagda"
    println(reverseString(str))

    val arr = intArrayOf(1, 2, 4, 5, 6, 7)
    findThePairs(arr, 6)
    IntArray(2)
    println(arr)
}

fun findThePairs(arr: IntArray, target: Int) {
    //array should be sorted

    if (arr.size <= 2) return

    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val calc = arr[left] + arr[right]

        if (calc < target)
            left += 1
        else if (calc > target)
            right -= 1
        else {
            println("${arr[left]} + ${arr[right]} = $calc")
            return
        }
    }
}
