package com.natiqhaciyef.technical_skills_kotlin.prep.questions.array


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
