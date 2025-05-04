package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun lemonadeChange(bills: IntArray):Boolean{
    val list = bills
    return counter(list)
}

fun counter(list: IntArray): Boolean {
    var five = 0
    var ten = 0
    var twenty = 0

    for (element in list) {
        if (element == 5 && five >=0)
            five += 1
        else if (element == 10 && ten >= 0) {
            ten += 1
            five -=1
        }else if (element == 20 && twenty >=0){
            twenty += 1
            if (ten == 0)
                five -= 3
            else{
                ten -= 1
                five -= 1
            }
        }
    }

    // println(five)
    return ten >= 0 && five >= 0 && twenty >= 0
}