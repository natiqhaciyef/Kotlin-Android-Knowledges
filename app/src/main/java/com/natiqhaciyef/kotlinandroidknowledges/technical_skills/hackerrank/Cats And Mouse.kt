package com.natiqhaciyef.kotlinandroidknowledges.technical_skills.hackerrank

import java.util.Scanner
import kotlin.math.abs


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val xyz = scan.nextLine().split(" ")

        val x = xyz[0].trim().toInt()

        val y = xyz[1].trim().toInt()

        val z = xyz[2].trim().toInt()

        val result = catAndMouse(x, y, z)

        println(result)
    }
}


fun catAndMouse(a: Int, b: Int, c: Int): String{
    return if(abs(b-c) > abs(a-c)){
        "Cat A"
    }else if(abs(b-c) < abs(a-c)){
        "Cat B"
    }else{
        "Mouse C"
    }
}