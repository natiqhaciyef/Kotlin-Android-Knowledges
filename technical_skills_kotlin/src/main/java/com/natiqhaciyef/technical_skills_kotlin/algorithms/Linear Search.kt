package com.natiqhaciyef.technical_skills_kotlin.algorithms


// All examples return index of element in nums array (if array doesn't contain element then returns -1)

/** Common/General search way of linear search (CLS or GLS)
 * The main problem in this example is the repeated search, even if the index of the element is found.
 * It repeats more than expected. All examples returns O(n) n = nums.size
 *
 * @param nums is the container of elements, element is the searched one.
 * @return index of element
 * @exception -1
 *
 * @runtime O(n) = n * (t1 + t2 + t3 + p2) + (p1 + p3 + t1 + t2)
 * @runtime Ѳ(n) = n * (t1 + t2 + t3) + (p1 + p2 + p3 + t1 + t2)
 * @runtime Ω(n) = t1 + t2 + t3 + p1 + p2 + p3
 */
fun linearSearch(nums: IntArray, element: Int): Int {
    // holds index      => p1
    var index = -1

    // checks i >= 0            => t1
    // checks i < nums.size     => t2
    for (i in nums.indices) {
        // checks nums[i] equals element   => t3
        if (nums[i] == element)
        // sets new value to index      => p2
            index = i
    }
    // returns correct index    => p3
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
 *
 * @runtime O(n) = n * (t1 + t2 + t3) + p3
 * @runtime Ѳ(n) = n * (t1 + t2 + t3) + p2
 * @runtime Ω(n) = t1 + t2 + t3 + p2
 */
fun betterLinearSearch(nums: IntArray, element: Int): Int {
    // checks i >= 0            => t1
    // checks i < nums.size     => t2
    for (i in nums.indices) {
        // checks nums[i] equals element   => t3
        if (nums[i] == element)
            // returns found index   => p2
            return i
    }

    // returns index  => p3
    return -1
}


/** Sentinel linear search (SLS)
 * SentinelLinearSearch solves 2 problems in CommonLinearSearch.
 * First, when element is found then stops repeating search. Second is no more index variable
 * should be created. Even if it is the optimal solution than linear search, it is not the best way
 * of linear search algorithms.
 *
 * @param nums is the container of elements, element is the searched one.
 * @return index of element
 * @exception if element did not find in the nums then returns -1
 *
 * @runtime O(n) = n * (t1 + p5) + t1 + p1 + p2 + p3 + p4 + p6 + t2 + t3 + p7 + p8
 * @runtime Ѳ(n) = n * (t1 + t2 + t3) + t1 + p1 + p2 + p3 + p4 + p6 + t2 + t3 + p7 + p8
 * @runtime Ω(n) = t1 + t2 + t3 + t1 + p1 + p2 + p3 + p4 + p6 + t2 + t3 + p7 + p8
 */
fun sentinelLinearSearch(nums: IntArray, element: Int): Int {
    // creates size holder but it is not necessary that is why we wouldn't calculate    => a1
    val n = nums.size - 1
    // setting last value of element to holder    => p1
    val holder = nums[n]
    // changing last element of array    => p2
    nums[n] = element

    // creating counter    => p4
    var i = 0

    // checking condition   => t1
    while (nums[i] != element) {
        // operation: increasing counter  => p5
        i += 1
    }

    // setting back to last index of array holder  => p6
    nums[n] = holder

    // checking i < n condition              => t2
    // also nums[n] == element condition     => t3
    if (i < n || nums[n] == element)
        // return if arr contains  => p7
        return i

    // return if arr does not contain  => p8
    return -1
}


/** Recursive linear search (RLS)
 * RecursiveLinearSearch same as sentinel linear search but using different way to calculate
 *
 * @param nums is the container of elements, element is the searched one, size of array(container)
 * @return index of element
 * @exception if element did not find in the nums then returns -1
 *
 * @runtime O(n) = n * (t1 + t2) + p1
 * @runtime Ѳ(n) = n * (t1 + t2) + p1
 * @runtime Ω(n) = t1 + t2 + p1
 */

fun recursiveLinearSearch(nums: IntArray, element: Int, index: Int): Int {
    // checks the index < 0 condition   => t1
    if (index < 0)
        return -1

    // checks num[index] == element     => t2
    return if (nums[index] == element)
        // returns index     => p1
        index
    else
        // returns next stage of loop     => f(n-1)
        recursiveLinearSearch(nums, element, index - 1)
}


fun main() {
    val arr = intArrayOf(12, 9, 16, 8, 14, 5, 42, 19, 1, 4, 2, 7)
    println(linearSearch(arr, 14))
    println(betterLinearSearch(arr, 11))
    println(sentinelLinearSearch(arr, 11))
    println(recursiveLinearSearch(arr, 11, arr.size - 1))
}