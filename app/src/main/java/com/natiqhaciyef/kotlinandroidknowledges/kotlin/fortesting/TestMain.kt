package com.natiqhaciyef.kotlinandroidknowledges.kotlin.fortesting

fun main() {

}

fun unReach(someNullable: String?){
    val nonNull: String = someNullable ?: throw NotImplementedError()
    nonNull.last()

    val thing: Nothing = TODO()
}