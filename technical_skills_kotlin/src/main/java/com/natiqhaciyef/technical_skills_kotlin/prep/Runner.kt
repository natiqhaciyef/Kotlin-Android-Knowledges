package com.natiqhaciyef.technical_skills_kotlin.prep

fun main() {
    println(anyCommonItems(intArrayOf(1,2,3,4,5), intArrayOf(5,6,7,8,9)))
    println(anyCommonItems(intArrayOf(1,2,3,4,5), intArrayOf(6,7,8,9)))
}

fun anyCommonItems(array1: IntArray, array2: IntArray): Boolean {
    val map = mutableMapOf<Int, Boolean>()
    for(element in array1){
        map[element] = true
    }

    for(element in array2){
        if(map[element] == true){
            return true
        }
    }

    return false
}
