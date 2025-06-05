package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

// Not Optimal solution
fun smallestEquivalentStringWorst(s1: String, s2: String, baseStr: String): String {
    // Topics: Union Find, String
    if(s1.length != s2.length) return ""

    val map = mutableMapOf<Char, MutableSet<Char>>()
    for(i in s1.indices){
        val ch1 = s1[i]
        val ch2 = s2[i]

        val list1 = map.getOrDefault(ch1, mutableSetOf())
        list1.add(ch1)
        list1.add(ch2)


        val list2 = map.getOrDefault(ch2, mutableSetOf())
        list2.add(ch1)
        list2.add(ch2)


        val actList = if(list2.size > list1.size) list2 else list1

        for(first in list1){
            val check = map.getOrDefault(first, mutableSetOf())

            if(check.isNotEmpty())
                actList.addAll(check)
            map[first] = actList
        }

        for(second in list2){
            val check = map.getOrDefault(second, mutableSetOf())

            if(check.isNotEmpty())
                actList.addAll(check)
            map[second] = actList
        }
    }

    // println(map)

    val charMap = mutableMapOf<Char, Char>()
    for((key, value) in map){
        if(value.isNotEmpty()){
            val smallOne = findSmallCharInList(value)
            charMap[key] = smallOne
        }
    }

    var result = ""
    for(ch in baseStr){
        val current = charMap[ch] ?: ch

        result += current
    }

    return result
}

fun findSmallCharInList(set: MutableSet<Char>): Char{
    var result: Char = set.first()

    for(ch in set){
        if(ch - 'a' < result - 'a')
            result = ch
    }

    return result
}


// Optimal
fun smallestEquivalentStringOptimal(s1: String, s2: String, baseStr: String): String {
    val parent = IntArray(26) { it }  // Each character’s parent (0 = 'a', 1 = 'b', ...)

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])  // Path compression
        }
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val px = find(x)
        val py = find(y)
        if (px == py) return
        // Always attach the larger parent to the smaller one (by lexicographical order)
        if (px < py) {
            parent[py] = px
        } else {
            parent[px] = py
        }
    }

    for (i in s1.indices) {
        val x = s1[i] - 'a'
        val y = s2[i] - 'a'
        union(x, y)
    }

    // Build the result string by finding the representative of each character in baseStr
    val result = StringBuilder()
    for (c in baseStr) {
        val smallest = find(c - 'a') + 'a'.toInt()
        result.append(smallest.toChar())
    }

    return result.toString()
}
