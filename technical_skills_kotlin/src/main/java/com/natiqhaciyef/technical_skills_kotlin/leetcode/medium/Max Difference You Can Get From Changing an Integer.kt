package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium

fun maxDiff(num: Int): Int {
    // Topics: Greedy, Math

    // pick a digit in 0..9 => x
    // pick another digit in 0..9 => y
    // find all x in num and change to y

    // it will be the a

    // then do same operations to generate b

    // find the max difference between those two numbers a and b

    // Example:
    // Input: 901
    // a => 991
    // b => 101
    // result => 890

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    val str = num.toString()

    // Greedy method
    for(start in 0 .. 9){
        for(end in 0 .. 9){

            // Compares all possible methods
            if(start != end){
                val number = str.replace("$start", "$end")
                max = maxOf(number.toInt(), max)

                // It should not start with 0
                if(number[0] != '0')
                    min = minOf(number.toInt(), min)
            }
        }
    }



    return max - min
}