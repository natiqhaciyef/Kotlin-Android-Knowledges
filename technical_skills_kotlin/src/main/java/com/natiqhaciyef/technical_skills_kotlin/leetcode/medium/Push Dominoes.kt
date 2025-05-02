package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun pushDominoesWorst(dominoes: String): String {
    if(dominoes.length <= 1) return dominoes
    val result = dominoes.toMutableList()

    // Topics: Two Pointers, Strings, Dynamic Programming

    // input - ".L.R...LR..L.."
    // output - "LL.RR.LLRRLL.."

    // if we see right -> search to the next left
    // if between "cut" number divide two and mark one part as R, second as L
    // if between "tek" number divide two and central element stay as . others, R and L
    // if right has no any left after itself, mark as all R
    // if left has no any right before itself, mark as all L

    var slow = 0
    var fast = slow+1

    // "0123456"
    // "R.....L.."
    var lastCh = '.'

    while(fast < result.size && slow < result.size){
        when{
            result[fast] == '.' -> {
                if(fast == result.size-1 && result[slow] == 'R' && result[result.size-1] == '.'){
                    // println(result)
                    while(slow <= fast){
                        result[slow] = 'R'
                        slow += 1
                    }
                }
                fast += 1
            }

            result[fast] == 'L' -> {
                if(result[slow] == 'L'){
                    slow += 1
                    while(slow < fast){
                        result[slow] = 'L'
                        slow += 1
                    }
                }else if(result[slow] == 'R'){
                    val total = fast - slow- 1
                    val half = total/2

                    for(i in 1 .. half){
                        result[slow+i] = 'R'
                        result[fast-i] = 'L'
                    }
                }else{
                    while(slow < fast){
                        result[slow] = 'L'
                        slow += 1
                    }
                }

                // println(result)

                slow = fast
                fast += 1
            }

            result[fast] == 'R' -> {
                if(result[slow] == 'R'){
                    slow += 1
                    while(slow < fast){
                        result[slow] = 'R'
                        slow += 1
                    }
                }

                // println(result)

                slow = fast
                fast += 1
            }
        }
    }

    var strResult = ""

    for(element in result){
        strResult += element
    }

    return strResult
}

fun pushDominoesBest(dominoes: String): String {
    if (dominoes.length <= 1) return dominoes

    val result = dominoes.toCharArray()
    var slow = 0
    var fast = 0
    val n = result.size

    while (fast < n) {
        when (result[fast]) {
            '.' -> fast++
            'L' -> {
                if (result[slow] == 'L') {
                    // Fill all with 'L' from slow+1 to fast-1
                    for (i in slow + 1 until fast) {
                        result[i] = 'L'
                    }
                } else if (result[slow] == 'R') {
                    // Conflict: R ... L
                    val mid = (fast - slow - 1) / 2
                    for (i in 1..mid) {
                        result[slow + i] = 'R'
                        result[fast - i] = 'L'
                    }
                    // Middle remains '.' if odd count
                } else {
                    // Initial state: ... . . . L
                    for (i in slow until fast) {
                        result[i] = 'L'
                    }
                }
                slow = fast
                fast++
            }

            'R' -> {
                if (result[slow] == 'R') {
                    for (i in slow + 1 until fast) {
                        result[i] = 'R'
                    }
                }
                slow = fast
                fast++
            }
        }
    }

    // Handle tailing 'R' (like: R.....)
    if (result[slow] == 'R') {
        for (i in slow + 1 until n) {
            result[i] = 'R'
        }
    }

    return String(result)
}
