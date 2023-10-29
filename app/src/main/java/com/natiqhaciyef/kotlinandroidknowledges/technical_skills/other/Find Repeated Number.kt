package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.other

fun findFirstRepeatedNumber(list: MutableList<Int>): Int {
    val collector = mutableListOf<Int>()
    var difference = 0
    for (element in list) {
        if (!collector.contains(element))
            collector.add(element)
    }


    for (i in collector.indices){
        if (list[i] != collector[i]) {
            difference = list[i]
            break
        }
    }

    return difference
}


fun main() {
    println(findFirstRepeatedNumber(mutableListOf(1,14,12,5,12,9,0)))
}

