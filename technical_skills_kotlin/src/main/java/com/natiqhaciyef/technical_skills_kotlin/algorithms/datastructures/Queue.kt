package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures

interface Queue<T: Any> {
    val count: Int
    val isEmpty: Boolean

    fun peek():T?

    fun enqueue(element: T): Boolean

    fun dequeue(): T?
}

class QueueImpl<T: Any>: Queue<T> {
    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size
    override val isEmpty: Boolean
        get() = count == 0

    override fun peek(): T?{
        return storage.firstOrNull()
    }

    override fun enqueue(element: T): Boolean {
        return storage.add(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else storage.removeAt(0)
    }
}
