package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.clazz

import com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.annotations.MathematicalCalculation


open class OuterClass {
    private val info = "Empty info"

    companion object {
        private const val priceInfo = 1200
    }

    // inner class
    inner class InnerClass: OuterClass() {
        fun getInfoAgain(): String {
            return info
        }
    }


    // nested class
    class NestedClass : OuterClass(){
        fun getInfo(): Int {
            return priceInfo
        }
    }
}

fun main() {
    val inner = OuterClass().InnerClass()
    val nested = OuterClass.NestedClass()
    println(inner.getInfoAgain())
    MathematicalCalculation()
}