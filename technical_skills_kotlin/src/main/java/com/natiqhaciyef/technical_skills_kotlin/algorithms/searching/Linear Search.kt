package com.natiqhaciyef.technical_skills_kotlin.algorithms.searching

/** Time complexity
 *      Worst case: O(n)
 *      Best case: O(1)
 *
 *  Space complexity - O(1)
 */

fun linearSearch(list: List<Int>, searched: Int): Int{
    var result = -1

    for (i in list.indices){
        if (list[i] == searched)
            result = i
    }

    return result
}