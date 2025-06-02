package com.natiqhaciyef.technical_skills_kotlin.leetcode.hard

// Brute Force
fun candyBruteForce(ratings: IntArray): Int {
    if(ratings.size <= 1) return ratings.size

    //Topics: Array, Greedy

    // azalan siranin ilk numberini al
    // sayini tap (azalan element sirasi)
    // azalan sirani sifir et
    val list = IntArray(ratings.size) { 1 }
    var streak = 0
    for(i in 1 until ratings.size){
        // [1,2,3,3,1]

        // [1,2,3,4,5,3,2,2,3]
        // [1,2,3,4,5,2,1,1,2]
        when{
            ratings[i - 1] < ratings[i] -> {
                list[i] = list[i-1] + 1
            }

            ratings[i - 1] > ratings[i] -> {
                if(list[i-1] <= list[i] && streak == 0)
                    list[i-1] = list[i] + 1

                streak += 1
            }

            else -> {
                list[i] = 1
            }
        }
    }

    var j = 0
    while(j < streak){
        for(i in 1 until ratings.size){
            // [1,2,3,3,1]

            // [1,2,3,4,5,3,2,2,3]
            // [1,2,3,4,5,2,1,1,2]
            when{
                ratings[i - 1] < ratings[i] -> {
                    list[i] = list[i-1] + 1
                }

                ratings[i - 1] > ratings[i] -> {
                    if(list[i-1] <= list[i])
                        list[i-1] = list[i] + 1
                }

                else -> {
                    list[i] = 1
                }
            }
        }

        j+=1
    }

    return list.sum()
}

// Optimized
// From start (like left)
// From end (like right)
fun candyOptimized(ratings: IntArray): Int {
    val n = ratings.size
    if (n <= 1) return n

    val candies = IntArray(n) { 1 }

    // Left to Right pass
    for (i in 1 until n) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }

    // Right to Left pass
    for (i in n - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = maxOf(candies[i], candies[i + 1] + 1)
        }
    }

    return candies.sum()
}
