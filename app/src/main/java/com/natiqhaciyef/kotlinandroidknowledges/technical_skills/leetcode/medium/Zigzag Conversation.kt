package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.leetcode.medium

fun convert(s: String, numRows: Int): String {
    var result = ""
    var copy = s
    var counter = 0
    val numRS = numRows - 1
    var i = 0
    val array = mutableListOf<MutableList<String>>()
    while (copy.length % numRows != 0) {
        copy += " "
    }

    if (numRows == 1)
        return s

    if (numRows > s.length)
        return ""

    while (i < s.length - 1) {
        val mList = mutableListOf<String>()

        if (i == 0 || i % numRows == numRS) {
            for (j in 0 until numRows) {
                if (counter < copy.length) {
                    mList.add(copy[counter].toString())
                    counter += 1
                } else {
                    break
                }
            }
        } else {
            for (j in 0 until numRows) {
                if (counter < copy.length) {
                    if (j == numRows - i % numRS - 1 && i % numRS != 0) {
                        mList.add(copy[counter].toString())
                        counter += 1
                        println(numRows - i % numRS - 1)
                    } else {
                        if (i % numRS != 0)
                            mList.add(" ")
                    }
                }
            }
        }
        array.add(mList)
        i += 1
    }

    array.removeIf { it.isEmpty() }
    println(array)

    for (k in 0 until array[0].size) {
        for (j in array.indices) {
            try {
                if (array[j][k] != " ")
                    result += array[j][k]
            }catch (e:Exception){
                array[j].add(" ")
                if (array[j][k] != " ")
                    result += array[j][k]
            }
        }
    }


    return result
}

fun convertFast(s: String, numRows: Int): String {
    // Handle special cases
    if (numRows == 1 || numRows >= s.length) {
        return s
    }

    val rows = Array(numRows) { StringBuilder() }
    var direction = -1 // 1 for down, -1 for up
    var currentRow = 0

    for (char in s) {
        rows[currentRow].append(char)

        // Change direction if we reach the top or bottom row
        if (currentRow == 0 || currentRow == numRows - 1) {
            direction *= -1
        }

        currentRow += direction
    }

    val result = StringBuilder()
    for (row in rows) {
        result.append(row)
    }

    return result.toString()
}


fun main() {
    println(convert("PAYPALISHIRING", 4))
    println(convert("ABCD", 3))

}