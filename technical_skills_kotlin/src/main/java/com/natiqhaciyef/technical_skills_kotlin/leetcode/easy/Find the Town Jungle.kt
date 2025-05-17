package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

//Brute force
fun findJudge(n: Int, trust: Array<IntArray>): Int {
    // Topics: Array, HashMap, Graph

    // we should create a Map<Int,List>
    // which List represents trusted people

    val map = mutableMapOf<Int, Int>()
    val set = mutableSetOf<Int>()
    for(arr in trust){
        set.add(arr[1])
        set.add(arr[0])

        val current = map.getOrDefault(arr[1], 0)
        map[arr[1]] = current + 1
    }

    var target = -1

    for (key in map.keys){
        if(map[key]!! +1 == set.size)
            target = key
    }

    for (tr in trust){
        if(tr[0] == target){
            return -1
        }
    }

    return target
}

//Little optimal
fun findJudgeOpt1(n: Int, trust: Array<IntArray>): Int {
    if(trust.isEmpty() && n == 1) return 1
    if(trust.size < n-1) return -1
    // Topics: Array, HashMap, Graph

    // we should create a Map<Int,Int>
    // which key:Int displays number and value:Int represents trusted people count

    val arr = IntArray(trust.size * trust[0].size + 1)
    val set = mutableSetOf<Int>()

    for(tr in trust){
        set.add(tr[0])
        set.add(tr[1])

        arr[tr[0]] = arr[tr[0]] - 1
        arr[tr[1]] = arr[tr[1]] + 1
    }

    var target = -1
    var size = set.size

    for (key in arr.indices){
        if(arr[key]!! + 1 == size)
            target = key
    }

    return target
}

//More optimal
fun findJudgeOpt2(n: Int, trust: Array<IntArray>): Int {
    val trustScores = IntArray(n + 1) // index 0 unused

    for ((a, b) in trust) {
        trustScores[a] -= 1   // a trusts someone → disqualify
        trustScores[b]+= 1   // b is trusted → increase score
    }

    for (i in 1..n) {
        if (trustScores[i]+1 == n) return i
    }

    return -1
}
