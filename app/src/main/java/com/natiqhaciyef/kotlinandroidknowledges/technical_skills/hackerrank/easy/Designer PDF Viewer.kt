package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank.easy

fun designerPdfViewer(h: Array<Int>, word: String): Int {
    // Write your code here
    var wordsMax = 0

    for (letter in word) {
        val index = letter.toInt() - 97
        if (wordsMax < h[index]){
            wordsMax = h[index]
        }
    }

    return wordsMax * word.length
}

fun main() {
    println('a'.toInt())
    println('b'.toInt())
}