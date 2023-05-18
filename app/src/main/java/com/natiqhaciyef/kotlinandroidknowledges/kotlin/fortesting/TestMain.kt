package com.natiqhaciyef.kotlinandroidknowledges.kotlin.fortesting

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val un = uploadUserName()
            val e = uploadUserEmail()
//            val un = async { uploadUserName() }
//            val e = async { uploadUserEmail() }
//            println("Inside scope : ${un.await()} ${e.await()}")
            println("Inside scope : $un $e")
        }

        println("Time : $time")
    }
}

suspend fun uploadUserName(): String {
    delay(2000)
    val username = "Natiq"
    println("User name downloaded")
    return username
}

suspend fun uploadUserEmail(): String {
    delay(3500)
    val email = "natiq@gmail.com"
    println("User email downloaded")
    return email
}