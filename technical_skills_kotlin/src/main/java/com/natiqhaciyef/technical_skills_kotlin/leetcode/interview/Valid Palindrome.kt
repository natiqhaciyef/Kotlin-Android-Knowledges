package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

fun isPalindrome(s: String): Boolean {
    if(s.length <= 1) return true
    var customS = s.lowercase()
    var left = 0
    var right = customS.length -1

    while(left <= right){
        if(!customS[left].isDigit() && !customS[left].isLetter()) {
            while(!customS[left].isDigit() && !customS[left].isLetter() && left < right){
                left+=1
            }
        }

        if(!customS[right].isDigit() && !customS[right].isLetter()) {
            while(!customS[right].isDigit() && !customS[right].isLetter() && left < right){
                right -=1
            }
        }

        if(customS[left] != customS[right])
            return false

        left +=1
        right -=1
    }


    return true
}
