package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
    // edge case
    if (tops.isEmpty() || bottoms.isEmpty() || tops.size != bottoms.size) return -1

    // Topics: Array, Greedy
    // #1
    // Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
    // Output: 2

    // check most repeated number in top
    val resultTop = checkSide(tops, bottoms)
    val resultBottom = checkSide(bottoms, tops)

    val swap = if (resultTop == -1 || resultBottom == -1) {
        if (resultTop != -1 || resultBottom != -1) {
            maxOf(resultTop, resultBottom)
        } else {
            -1
        }
    } else {
        minOf(resultTop, resultBottom)
    }


    return swap
}

fun checkSide(tops: IntArray, bottoms: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (value in tops) {
        val element = map.getOrDefault(value, 0)
        map[value] = element + 1
    }

    if (map.keys.size == 1)
        return 0

    var repeat = 0
    var common = 0
    for (key in map.keys) {
        if (map[key]!! > repeat) {
            common = key
            repeat = map[key]!!
        }
    }

    // println("common => $common")
    // println("repeat => $repeat")


    // till there we found most common num in tops

    // now check different numbers
    var swap = 0
    for (i in tops.indices) {
        if (tops[i] != common) {
            if (bottoms[i] == common) {
                swap += 1
            } else {
                // println("bottoms[i] => ${bottoms[i]}")
                swap = -1
                break
            }
        }
    }

    return swap
}
