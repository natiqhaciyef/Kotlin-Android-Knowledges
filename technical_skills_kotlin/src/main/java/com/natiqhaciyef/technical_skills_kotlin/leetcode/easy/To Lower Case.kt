package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun toLowerCase(s: String): String {
    if(s.isEmpty()) return s

    var result = ""
    for(i in s.indices){
        if(s[i] in 'A'..'Z'){
            result += ((s[i] + 32).toChar())
        }else{
            result += (s[i])
        }
    }

    return result
}