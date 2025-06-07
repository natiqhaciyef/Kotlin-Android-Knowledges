package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun clearStars(s: String): String {
    // Topics: String, HashTable, Stack, Greedy, Heap
    val arr = Array<MutableList<Int>>(26) { mutableListOf() }
    val tempS = s.toMutableList()

    var chIndex: Int
    for(i in s.indices){
        chIndex = s[i] - 'a'

        if(s[i] != '*'){
            val list = arr[chIndex]
            // adding index of char
            list.add(i)
            arr[chIndex] = list
        }else{
            // Remove
            for(l in arr){
                if(l.isEmpty()) continue

                val index = l.removeLast()
                tempS[index] = '*'

                break
            }
        }
    }

    var result = ""
    for (ch in tempS){
        if (ch == '*') continue

        result += ch
    }


    return result
}