package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

// Pretty freaky question
fun minMaxDifference(num: Int): Int {
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    val str = num.toString()

    for(start in 0 .. 9){
        for(end in 0 .. 9){
            if(start != end){
                val number =str.replace("$start", "$end")

                max = maxOf(number.toInt(), max)
                min = minOf(number.toInt(), min)
            }
        }
    }

    return max - min
}

fun main() {
    println(minMaxDifference(90))
    println("---")
    println(minMaxDifference(81))
    println("---")
    println(minMaxDifference(909))
    println("---")
    println(minMaxDifference(911))
}