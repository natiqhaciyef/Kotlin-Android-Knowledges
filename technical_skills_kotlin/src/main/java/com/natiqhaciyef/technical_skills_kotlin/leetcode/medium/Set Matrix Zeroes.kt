package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun setZeroes(matrix: Array<IntArray>): Unit {
    // first Y Index, second X Index
    val list = mutableListOf<Pair<Int, Int>>()

    // find the current zero
    var i = 0
    var j = 0

    while(i < matrix.size){

        if(matrix[i][j] == 0){
            list.add(Pair(i, j))
        }

        if(j == matrix[0].size-1){
            i += 1
            j = 0
        }else{
            j += 1
        }
    }


    // now should set zeroes
    for(pair in list){

        // first horizontal
        var xCopy = 0
        while(xCopy < matrix[pair.first].size){
            matrix[pair.first][xCopy] = 0
            xCopy += 1
        }

        // second vertical
        var yCopy = 0
        while(yCopy < matrix.size){
            matrix[yCopy][pair.second] = 0
            yCopy += 1
        }
    }
}