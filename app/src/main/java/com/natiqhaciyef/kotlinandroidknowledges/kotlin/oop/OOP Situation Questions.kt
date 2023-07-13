package com.natiqhaciyef.kotlinandroidknowledges.kotlin.oop

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

    // 1
    val object1 = User()

    // 2
    val object2 = User::class.java.newInstance()

    // 3
    val object3 = object : User() {

    }

}


interface Person {
    var name: String
    fun getInfo()
    fun getDepartment()

}

open class User: Person {
    override var name: String = ""
    override fun getInfo() {
        println("User: $name")
    }

    override fun getDepartment() {

    }
}

class Employee(
    private val employeeName: String,
    private val email: String,
    private val age: Int
) : Person {
    override var name: String = employeeName

    override fun getInfo() {
        println("Employee info: Name - $name, Age - $age, Email - $email")
    }

    override fun getDepartment() {
        println("IT department")
    }
}

class Manager(
    private val managerName: String,
    private val email: String,
    private val age: Int,
    private val department: String,
    private val key: String
) : Person {
    override var name: String = managerName

    override fun getInfo() {
        println("Manager info: Name - $name, Age - $age, Email - $email, Department - $department, Key - $key")
    }

    override fun getDepartment() {
        println("HR department")
    }
}

