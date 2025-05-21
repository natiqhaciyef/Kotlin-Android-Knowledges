package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

// Solution 1
fun findCenter1(edges: Array<IntArray>): Int {
    var remains = edges[0][0]
    var count = 0

    if(edges[count+1][0] != remains && edges[count+1][1] != remains)
        remains = edges[0][1]


    while(count < edges.size-1){
        count += 1

        if(edges[count][0] != remains && edges[count][1] != remains)
            return -1
    }

    return remains
}

fun findCenter2(edges: Array<IntArray>): Int {
    return if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
        edges[0][0]
    else
        edges[0][1]
}