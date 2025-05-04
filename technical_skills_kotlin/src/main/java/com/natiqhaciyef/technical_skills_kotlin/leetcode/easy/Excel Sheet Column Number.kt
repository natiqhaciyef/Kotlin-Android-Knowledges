package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

import kotlin.math.pow

fun titleToNumber(columnTitle: String): Int {
    var result = 0
    var n = 0.0

    // ABC
    for(i in columnTitle.length-1 downTo 0){
        result += (columnTitle[i].code - 64) * (26.0.pow(n)).toInt()
        n+=1
    }

    return result
}
