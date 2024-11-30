package com.natiqhaciyef.technical_skills_kotlin.leetcode.medium


fun intToRoman(num: Int): String {
    var result = ""
    var number = num
    var stage = 0

    while (number > 0) {
        result = "${stageConverter(number % 10, stage)}$result"
        number -= number % 10
        number /= 10
        stage += 1
    }

    return result
}

fun stageConverter(number: Int, stage: Int): String {
    val numberTemp = when (Math.pow(10.0, stage.toDouble()).toInt()) {
        1 -> "I"
        10 -> "X"
        100 -> "C"
        1000 -> "M"
        else -> "-"
    }

    var result = ""
    for (i in 1..number) {
        result += numberTemp
    }


    return romanianCheck(result, stage)
}

fun romanianCheck(romanianNumberRaw: String, stage: Int): String {
    val numberTemp = when (Math.pow(10.0, stage.toDouble()).toInt()) {
        1 -> "V"
        10 -> "L"
        100 -> "D"
        else -> "-"
    }

    val numberTempRaw = when (Math.pow(10.0, stage.toDouble() + 1).toInt()) {
        1 -> "I"
        10 -> "X"
        100 -> "C"
        1000 -> "M"
        else -> "-"
    }

    return if (romanianNumberRaw.length <= 3) {
        romanianNumberRaw
    } else if (romanianNumberRaw.length in 4..5) {
        if (romanianNumberRaw.length == 4)
            "${romanianNumberRaw[0]}$numberTemp"
        else
            numberTemp
    } else if (romanianNumberRaw.length in 6..8) {
        val count = romanianNumberRaw.length - 5
        var result = numberTemp


        for (i in 1..count) {
            result += romanianNumberRaw[0]
        }

        result
    } else {
        "${romanianNumberRaw[0]}$numberTempRaw"
    }
}

fun main() {
    println(intToRoman(1994))
    println(stageConverter(4, 0))
}