package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

interface Handler {
    fun setNext(handler: Handler?)
    fun handle(request: String): Boolean
}

class FirstHandler : Handler {
    private var nextHandler: Handler? = null

    override fun setNext(handler: Handler?) { nextHandler = handler }

    override fun handle(request: String): Boolean {
        if (request.startsWith("First")) {
            println("FirstHandler handled the request: $request")
            return true
        } else {
            return nextHandler?.handle(request) ?: false
        }
    }
}

class SecondHandler : Handler {
    private var nextHandler: Handler? = null

    override fun setNext(handler: Handler?) { nextHandler = handler }

    override fun handle(request: String): Boolean {
        if (request.startsWith("Second")) {
            println("SecondHandler handled the request: $request")
            return true
        } else {
            return nextHandler?.handle(request) ?: false
        }
    }
}


fun main() {
    val firstHandler = FirstHandler()
    val secondHandler = SecondHandler()
    firstHandler.setNext(secondHandler)

    val requests = listOf("FirstRequest", "SecondRequest", "OtherRequest", "ThirdRequestAgain")
    requests.forEach { request ->
        if (!firstHandler.handle(request)) {
            println("Request $request was not handled by any handler.")
        }
    }
}
