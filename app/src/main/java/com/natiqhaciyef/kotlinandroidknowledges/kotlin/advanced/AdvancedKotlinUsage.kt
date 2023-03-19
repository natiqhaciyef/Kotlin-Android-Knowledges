package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced

fun main() {

}

fun unReach(someNullable: String?){
    val nonNull: String = someNullable ?: throw NotImplementedError()
    nonNull.last()

    val thing: Nothing = TODO("String")
}