package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.fp.arrow

import arrow.core.*

val result: Either<String, Int> = Either.Right(42)
val failed: Either<String, Int> = Either.Left("Something happened which we don't understand - so error")


fun main() {

    val message = result.fold(
        ifLeft = { "Failed: $it" },
        ifRight = { "Success: $it" }
    )

    println(message)
}
