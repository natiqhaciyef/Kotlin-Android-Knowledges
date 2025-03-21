package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures

class NodeElement<T : Any>(
    var value: T,
    var next: NodeElement<T>? = null
) {

    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }

    fun printReversed() {
        next?.printReversed()

        if (next != null) {
            print(" -> ")
        }

        print(value.toString())
    }
}


fun main() {
    val linkedList = NodeElement(12, NodeElement(10, NodeElement(101, NodeElement(190, NodeElement(1001)))))

//    println(linkedList.toString())
    linkedList.printReversed()
}