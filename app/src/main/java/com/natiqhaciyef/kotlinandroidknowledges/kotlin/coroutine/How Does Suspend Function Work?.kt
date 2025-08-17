package com.natiqhaciyef.kotlinandroidknowledges.kotlin.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.*
import kotlinx.coroutines.delay


/*** Lifecycle of Suspend function over given example:
 *      suspend fun myFunction() {
 *          println("Before")
 *          delay(1000)
 *          println("After")
 *      }
 *
 * Coroutine (suspended) ──> [Continuation stored]
 *                           ↓
 * Delay schedules task: Runnable { continuation.resume(Unit) }
 *                           ↓
 * Scheduler/Handler keeps it in a timer wheel / queue
 *                           ↓ (after 1000ms)
 * Dispatcher executes Runnable on its thread
 *                           ↓
 * continuation.resumeWith(Result.success(Unit)) called
 *                           ↓
 * Coroutine resumes at label 1
 *
 * Read this: https://kt.academy/article/cc-under-the-hood
 */



//TODO: Actual version
suspend fun myFunction(surname: String) {
    println("Before")
    var name = "John"
    delay(1000) // suspending
    println("His name is: $name $surname")
    println("After")
}

//TODO: Converted Kotlin version

// Custom ContinuationImpl base class to simulate compiler behavior
// Mimic compiler constant
val COROUTINE_SUSPENDED = Any()

// Our manual state-machine version of the function
fun myFunction(surname: String?, completion: Continuation<Any?>): Any? {
    var continuation: MyFunctionContinuation
    if (completion is MyFunctionContinuation) {
        continuation = completion
        if ((continuation.label and Int.MIN_VALUE) != 0) {
            continuation.label -= Int.MIN_VALUE
        }
    } else {
        continuation = MyFunctionContinuation(completion)
    }

    var result = continuation.result
    var name: String? = null

    when (continuation.label) {
        0 -> {
            println("Before")
            name = "John"
            continuation.surname = surname
            continuation.name = name
            continuation.label = 1
            // simulate suspension
            return COROUTINE_SUSPENDED
        }
        1 -> {
            name = continuation.name as String
            // surname was stored before
        }
        else -> throw IllegalStateException("call to 'resume' before 'invoke' with coroutine")
    }

    println("His name is: $name $surname")
    println("After")
    return Unit
}

// Custom continuation for this function
class MyFunctionContinuation(completion: Continuation<Any?>?) :
    ContinuationImpl(completion) {
    var surname: Any? = null
    var name: Any? = null

    override fun invokeSuspend(result: Any?): Any? {
        this.result = result
        this.label = this.label or Int.MIN_VALUE
        return myFunction(null, this)
    }
}

abstract class ContinuationImpl(
    val completion: Continuation<Any?>?
) : Continuation<Any?> {

    var result: Any? = null
    var label: Int = 0

    override val context: CoroutineContext
        get() = completion?.context ?: EmptyCoroutineContext

    override fun resumeWith(result: Result<Any?>) {
        this.result = result.getOrNull()
        val outcome = try {
            invokeSuspend(this.result)
        } catch (e: Throwable) {
            completion?.resumeWith(Result.failure(e))
            return
        }
        if (outcome != COROUTINE_SUSPENDED) {
            completion?.resumeWith(Result.success(outcome))
        }
    }

    abstract fun invokeSuspend(result: Any?): Any?
}
