package com.natiqhaciyef.kotlinandroidknowledges.kotlin.oop

/**
* 2 class yaradın və arasında Parent Child əlaqəsi qurulsun. Child classı Parentdən törədilmiş olsun
 * Parent classının 3 constructoru olacaq : 1 primary və 2 secondary. Primary daxilində name: String, age: Int,
 * Secondary-lar daxilində 1cisində age: Int, name: String, id: Int və 2cisində age: Int, name: String, parentType: String
 * fieldləri olsun.
 * Child classının 1 primary constructoru olsun və daxilində ötürücü (not initialized parameters) name: String, age: Int fieldləri olsun
 * Child classında funksiya yazaraq name return edin və elə olsunki, child.name edərək bu parameterə müdaxilə etmək mümkün olmasın.
 * Funksiyanı getUserName() olaraq adlandırın. Private açar sözü istifadə edilməsi mümkündür.
 *
* */


open class Parent(
    private val name: String, val age: Int
) {
    var parentType = "Not-selected"

    constructor(name: String, age: Int, parentType: String) : this(name, age) {
        this.parentType = parentType
    }

    constructor(name: String, age: Int, id: Int) : this(name, age)

    protected fun getNameProtected(child: Child): String = "Child name: $name"
}

class Child(name: String, age: Int) : Parent(name, age) {
    private val name = "Child name: $name"
    fun getChildName1(): String = getNameProtected(child = this)
    fun getChildName2(): String = name
}


fun main() {
    val child = Child("Iko", 14)

    println(child.getChildName1())
    println(child.getChildName2())
}