package com.natiqhaciyef.technical_skills_kotlin.other.util

fun main() {
    useOfZip()
}

fun useOfZip(){
    val listLetters = mutableListOf("a", "b", "c", "d", "e")
    val listNumbers = mutableListOf(1, 2, 3, 4, 5)

    val zipped = listNumbers.zip(listLetters)
    println(zipped)
}

