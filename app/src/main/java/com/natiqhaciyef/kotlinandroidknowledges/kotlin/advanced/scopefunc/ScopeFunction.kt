package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.scopefunc

fun main() {
    val person = Person("Natig", 21)

    val applyResult = person.apply {
        // without receiver
        // return type current object
    }

    // extension function
    val runResult = person.run {
        // without receiver
        // return type new object
    }

    // just function
    val withResult = with(person) {
        // without receiver
        // return type new object
    }

    val letResult = person.let {
        // with receiver
        // return type new object
    }

    val alsoResult = person.also {
        // with receiver
        // return type current object
    }
}
