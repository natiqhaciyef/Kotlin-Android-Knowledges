package com.natiqhaciyef.technical_skills_kotlin.algorithms.datastructures

import java.util.*

interface Queue<T: Any> {
    val count: Int
    val isEmpty: Boolean

    fun peek():T?

    fun enqueue(element: T): Boolean

    fun dequeue(): T?
}

class QueueImpl<T: Any>: Queue<T> {
    private val storage = arrayListOf<T>()
    val size: Int
        get() = storage.size

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

fun main() {
    val priorityQueue = PriorityQueue<String>()
    val queue: java.util.Queue<Double> = LinkedList()

    priorityQueue.add("A")
    priorityQueue.add("A")
    priorityQueue.add("N")
    priorityQueue.add("A")
    priorityQueue.add("D")
    priorityQueue.add("B")
    priorityQueue.add("C")
    priorityQueue.add("C")

    while(priorityQueue.isNotEmpty()){
        println(priorityQueue.poll())
    }
}