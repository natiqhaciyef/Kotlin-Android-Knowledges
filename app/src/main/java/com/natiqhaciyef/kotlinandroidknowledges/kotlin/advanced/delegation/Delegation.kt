package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.delegation


interface D{
    var name: String
    fun getDName(name: String)
}

class DelegationTest(n:String) : B(), D by A(n) {

}

class A(var n: String): D{
    override var name: String
        get() = this.n
        set(value){
            n = value
        }

    override fun getDName(name: String) {
        println("$name is delegation")
    }

}

open class B{
    fun getBName(str: String) {
        println(str)
    }
}


fun main() {
    val delegationTest = DelegationTest("User")
    delegationTest.name = "User"
    println(delegationTest.name)
}

