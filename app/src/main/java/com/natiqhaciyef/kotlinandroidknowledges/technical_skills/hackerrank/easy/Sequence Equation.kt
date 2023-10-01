package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.easy

fun permutationEquation(p: Array<Int>): Array<Int> {
    // Write your code here
    val list = p.toMutableList()
    val result = mutableListOf<Int>()
    for (i in list.indices){
        result.add(list.indexOf(list.indexOf(i + 1) + 1) + 1)
    }

    println(result)
    return result.toTypedArray()
}

fun main() {
    val array = arrayOf(4, 3, 5, 1, 2)

    permutationEquation(array)
}