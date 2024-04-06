package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.annotations


class Seasons(
    val name: String,
)

fun main() {
    val runtimeKClass = Seasons::class
    val runtimeClassJava = runtimeKClass.constructors
    val runtimeClassKotlin = runtimeKClass.annotations

    println(runtimeClassJava)
    println(runtimeClassKotlin)
}
