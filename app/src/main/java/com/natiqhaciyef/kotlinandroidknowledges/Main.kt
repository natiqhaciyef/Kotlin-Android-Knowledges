package com.natiqhaciyef.kotlinandroidknowledges

import kotlinx.coroutines.launch
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import javax.inject.Inject
import kotlin.math.abs
import kotlin.system.measureTimeMillis


fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    // edge case - if list empty or size less than 3
    if (arr.size < 3) return 0

    // create loop with arr.size-3
    // check conditions
    // count all matched elements (create set for handle this)
    var count = 0
    var i = 0
    var j: Int
    var k: Int

    while (i < arr.size - 2) {
        j = i + 1

        if (condition(arr[i], arr[j], a))
        while (j < arr.size - 1) {
            k = j + 1

            if (condition(arr[i], arr[j], a) && condition(arr[j], arr[k], b))
            while (k < arr.size) {
                if (condition(arr[i], arr[j], a)
                    && condition(arr[j], arr[k], b)
                    && condition(arr[i], arr[k], c)
                ) {
                    println("${arr[i]} - ${arr[j]} - ${arr[k]}")
                    count++
                }

                k++
            }
            j++
        }
        i++
    }

    return count
}

private fun condition(element1: Int, element2: Int, expected: Int): Boolean {
    return abs((element1 - element2)) <= expected
}