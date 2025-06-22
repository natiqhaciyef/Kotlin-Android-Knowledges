package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun divideString(s: String, k: Int, fill: Char): Array<String> {
    // separate string to k substrings:
    //  1. first we should separate sequentially
    //  2. if substring has no enough char complete with "fill"

    // first we should check that is it possible to directly separate to k
    var str = s
    val sizeOfArr = if(s.length % k == 0)
        s.length/k
    else{
        var fillCount = k - s.length % k

        for(i in 0 until fillCount){
            str += fill
        }

        s.length/k + 1
    }

    val arr = Array<String>(sizeOfArr) { "" }

    var temp = ""
    var j = 1
    var n = 0

    while(j < str.length+1) {
        temp += str[j-1]

        if(j % k == 0){
            arr[n] = temp
            n += 1
            temp = ""
        }
        j += 1
    }

    return arr
}