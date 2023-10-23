package com.natiqhaciyef.kotlinandroidknowledges.algorithms.custom_collections



class CustomQueue<T> {
    private var front: Node<T>? = null
    private var rear: Node<T>? = null

    fun isEmpty(): Boolean {
        return front == null
    }

    fun enqueue(value: T) {
        val newNode = Node(value)
        if (isEmpty()) {
            front = newNode
            rear = newNode
        } else {
            rear?.front = newNode
            rear = newNode
        }
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            return null
        }

        val removedValue = front?.data
        front = front?.front

        if (front == null) {
            rear = null
        }

        return removedValue
    }

    fun getFront(): T? {
        return front?.data
    }
}

