package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy


fun findWords(words: Array<String>): Array<String> {
    // Topics: Array, HashTable, String

    val map = mutableMapOf<Char, Int>()

    for(ch in "qwertyuiop"){
        map[ch] = 1
    }

    for(ch in "asdfghjkl"){
        map[ch] = 2
    }

    for(ch in "zxcvbnm"){
        map[ch] = 3
    }


    val list = mutableListOf<String>()
    for(w in words){
        if(w.isEmpty())
            continue

        val word = w.lowercase()
        val first = word[0]
        val shouldBe = map[first]!!
        var available = true

        for(i in 1 until word.length){
            val ch = word[i]
            if(map[ch]!! != shouldBe){
                available = false
                break
            }
        }

        if(available)
            list.add(w)
    }

    return list.toTypedArray()
}