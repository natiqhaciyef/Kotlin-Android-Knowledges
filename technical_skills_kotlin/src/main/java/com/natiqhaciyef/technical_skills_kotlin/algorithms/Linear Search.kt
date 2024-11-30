package com.natiqhaciyef.technical_skills_kotlin.algorithms


// All examples return index of element in nums array (if array doesn't contain element then returns -1)

/** Common/General search way of linear search (CLS or GLS)
 * The main problem in this example is the repeated search, even if the index of the element is found.
 * It repeats more than expected. All examples returns O(n) n = nums.size
 *
 * @param nums is the container of elements, element is the searched one.
 * @return index of element
 * @exception -1
 */
fun linearSearch(nums: IntArray, element: Int): Int {
    var index = -1
    for (i in nums.indices) {
        if (nums[i] == element)
            index = i
    }
    return index
}


/** Better linear search (BLS)
 * BetterLinearSearch solves 2 problems in CommonLinearSearch.
 * First, when element is found then stops repeating search. Second is no more index variable
 * should be created. Even if it is the optimal solution than linear search, it is not the best way
 * of linear search algorithms.
 *
 * Because, it creates =>  n * 2 * condition
 * n = loops count
 * condition = if-else statement
 *
 * Why 2 * condition ? Because, "i in nums.indices" is first conditional case, "nums[i] == element" is the
 * second conditional case.
 *
 * @param nums is the container of elements, element is the searched one.
 * @return index of element
 * @exception if element did not find in the nums then returns -1
 */
fun betterLinearSearch(nums: IntArray, element: Int): Int {
    for (i in nums.indices) {
        if (nums[i] == element)
            return i
    }
    return -1
}


/** Sentinel linear search (BLS)
 * SentinelLinearSearch solves 2 problems in CommonLinearSearch.
 * First, when element is found then stops repeating search. Second is no more index variable
 * should be created. Even if it is the optimal solution than linear search, it is not the best way
 * of linear search algorithms.
 *
 * @param nums is the container of elements, element is the searched one.
 * @return index of element
 * @exception if element did not find in the nums then returns -1
 */
fun sentinelLinearSearch(nums: IntArray, element: Int): Int {
    val n = nums.size - 1
    val holder = nums[n]
    nums[n] = element

    var i = 0
    while (nums[i] != element) {
        i += 1
    }

    nums[n] = holder
    if (i < n || nums[n] == element) return i

    return -1
}


fun main() {
    val arr = intArrayOf(12, 9, 16, 8, 14, 5, 42, 19, 1, 4, 2, 7)
    println(linearSearch(arr, 11))
    println(betterLinearSearch(arr, 11))
    println(sentinelLinearSearch(arr, 11))
}