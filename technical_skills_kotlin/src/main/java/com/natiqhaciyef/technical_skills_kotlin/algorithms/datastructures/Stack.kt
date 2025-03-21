package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures

interface Stack<T : Any> {

    fun pop(): T?

    fun peek(): T?

    fun push(element: T)

    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}


class StackImpl<T : Any> : Stack<T> {
    private var storage = arrayListOf<T>()
    override val count = storage.size

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }
}