package com.natiqhaciyef.technical_skills_kotlin.prep.questions.array

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