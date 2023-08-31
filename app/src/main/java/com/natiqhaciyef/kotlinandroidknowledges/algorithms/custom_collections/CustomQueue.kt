package com.natiqhaciyef.kotlinandroidknowledges.algorithms.custom_collections


class Node<T>(val data: T) {
    var back: Node<T>? = null
}

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
            rear?.back = newNode
            rear = newNode
        }

        println("Front: $front")
        println("--------------------------")
        println("Rear: $rear")
        println("--------------------------")
        println("Rear: ${rear?.back}")


        println("-------------------------- \n -------------------------- \n")
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            return null
        }

        val removedValue = front?.data
        front = front?.back

        println("Front: $front")
        println("--------------------------")
        println("Rear: $rear")
        println("--------------------------")
        println("Rear: ${rear?.back}")

        if (front == null) {
            rear = null
        }

        return removedValue
    }

    fun getFront(): T? {
        return front?.data
    }
}

