package com.natiqhaciyef.technical_skills_kotlin.leetcode.easy

fun maxProfit(prices: IntArray): Int {
    var diff = 0
    var min = prices[0]

    //    Constraints:
    //    1 <= prices.length <= 105
    //    0 <= prices[i] <= 104
    //    O(N) -> runtime of function

    for (index in prices.indices) {
        if (prices[index] < min && index != prices.lastIndex){
            min = prices[index]
            //            println("Min: $min")
        }

        if (prices[index] - min > diff){
            diff = prices[index] - min
            //            println("Diff: $diff")
        }
    }

    return diff
}