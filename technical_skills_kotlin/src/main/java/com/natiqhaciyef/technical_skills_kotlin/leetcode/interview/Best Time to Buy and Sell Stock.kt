package com.natiqhaciyef.technical_skills_kotlin.leetcode.interview

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
//            println("Min $min")
        }

        if (prices[index] - min > diff){
            diff = prices[index] - min
//            println("Diff $diff")
        }
    }

    return diff
}


//    Example 1:
//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

//    Example 2:
//    Input: prices = [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transactions are done and the max profit = 0.
fun main() {
    val arr1 = intArrayOf(7,1,5,3,6,4)
    val arr2 = intArrayOf(7,6,4,3,1)
    val arr3 = intArrayOf(1,2)
    val arr4 = intArrayOf(2,4,1)
    val arr5 = intArrayOf(3,2,6,5,0,3)

    println(maxProfit(arr1))
    println(maxProfit(arr2))
    println(maxProfit(arr3))
    println(maxProfit(arr4))
    println(maxProfit(arr5))
}