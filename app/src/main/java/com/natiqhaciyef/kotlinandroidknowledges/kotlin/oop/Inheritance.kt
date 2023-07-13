package com.natiqhaciyef.kotlinandroidknowledges.kotlin.oop

open class P(val name: String, val age: Int) {

    fun addOwnParent(type: P): String {
        return type.javaClass.name
    }
}

class C(childName: String, childAge: Int) : P(childName, childAge) {
    fun getParentName() = super.name

    fun getClassNameFromParent() = addOwnParent(this)
}

class D : P("", 0) {

    fun getParentAge() = super.age

    fun getClassNameFromParent() = addOwnParent(this)

}

data class Inform(val name: String, val age: Int)

fun main() {
    val p = P("P", 0)
    val c = C("C", 1)
    val d = D()

    println(p.addOwnParent(c))
    println(p.addOwnParent(d))

    // Destructuring object structure
    val inform = Inform("Name", 0)
    val (name, age) = inform
    println(name)
    println(age)
}

