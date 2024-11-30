package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

fun circularArrayRotation(a: Array<Int>, k: Int, queries: Array<Int>): Array<Int> {
    var list = a.toMutableList()
    val returnList = mutableListOf<Int>()

    for (stage in 0 until k) {
        list = circularRotator(list)
    }

    for (element in queries) {
        returnList.add(list[element])
    }

    return returnList.toTypedArray()
}


fun circularRotator(staticList: MutableList<Int>): MutableList<Int> {
    if (staticList.isNotEmpty()) {
        val temp = staticList.removeAt(staticList.size - 1)
        staticList.add(0, temp)
    }
    return staticList
}


fun main() {
    println(circularArrayRotation(arrayOf(1, 2, 3), 2, arrayOf(2, 0)))
}