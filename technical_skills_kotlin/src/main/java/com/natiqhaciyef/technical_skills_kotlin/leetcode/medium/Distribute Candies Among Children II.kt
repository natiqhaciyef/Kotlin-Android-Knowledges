package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


// previous
private var count = 0L
fun distributeCandiesNonOptimal(n: Int, limit: Int): Long {
    // Topics: Math, Combinatorics, Enumaration
    // Total Elements = { 0 .. n } => n+2 => k
    if(n == 0) return 1L

    // There are two times 0
    // Combinations: k! / 3! * (k-3)! = k! / 6 * (k-3)!
    if(n / limit > 3 || (n % 3 != 0 && n/limit == 3)){
        return 0L
    }

    val currentLimit = if(n < limit) n else limit

    // Step 1
    // Find possible number combinations
    fun backtrack(list: MutableList<Int>){
        if(list.size == 3){
            // println(list)

            if(list.sum() == n)
                count += 1L

            return
        }
        for(i in 0 .. currentLimit){
            list.add(i)
            backtrack(list)
            list.remove(i)
        }

        return
    }

    backtrack(mutableListOf())
    println("count => $count")

    return count
}


fun distributeCandies(n: Int, limit: Int): Long {
    var totalWays = 0L

    for (i in 0..minOf(n, limit)) {
        // minJ
        val bound1 = n - i - limit
        println("bound1 = $bound1")
        val minJ = maxOf(0, bound1)
        println("minJ = $minJ")

        // maxJ
        val bound2 = n - i
        println("bound2 = $bound2")
        val maxJ = minOf(limit, n - i)
        println("maxJ = $maxJ")

        if (minJ <= maxJ) {
            totalWays += (maxJ - minJ + 1).toLong()
            println("totalWays => $totalWays")
        }
        println("------")
    }

    return totalWays
}


fun main() {
//    distributeCandies(10, 20)
    distributeCandies(10, 6)
}