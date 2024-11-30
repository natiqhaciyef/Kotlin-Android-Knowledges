package com.natiqhaciyef.technical_skills_kotlin.other


fun findEfficientSumOf(c: Int, list: MutableList<Int>): Int {
    var result = 0
    var max = 0
    var counter = 0

    while (counter < c) {
        max = findMax(list)
        list.remove(max)
        result += max
        counter += 1
    }

    return result
}


fun findMax(list: List<Int>): Int {
    var max = list[0]
    for (i in list) {
        if (i > max)
            max = i
    }

    return max
}

fun main() {
    val list = mutableListOf(6, 6, 6, 6, 6, 8, 8, 8, 7, 7, 7, 7)
    println(findEfficientSumOf(9, list))
}