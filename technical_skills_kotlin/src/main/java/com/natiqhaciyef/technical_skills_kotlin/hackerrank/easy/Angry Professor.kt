package com.natiqhaciyef.technical_skills_kotlin.hackerrank.easy

fun angryProfessor(k: Int, a: Array<Int>): String {
    // Write your code here
    var counter = 0

    for (minute in a){
        if (minute <= 0){
            counter += 1
        }
    }

    return if (counter >= k) "NO" else "YES"
}