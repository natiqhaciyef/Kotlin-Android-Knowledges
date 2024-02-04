package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.creational

import java.util.concurrent.ConcurrentLinkedQueue

interface PooledObject<T> {
    fun reset(): T
}

class ObjectPool<T : PooledObject<T>>(
    private val factory: () -> T,
    private val maxSize: Int = 10
) {
    private val pool: ConcurrentLinkedQueue<T> = ConcurrentLinkedQueue()

    init {
        repeat(maxSize) { pool.add(factory()) }
    }

    fun acquire(): T {
        return pool.poll() ?: factory()
    }

    fun release(obj: T) {
        if (pool.size < maxSize) {
            pool.add(obj)
        }
    }
}

// Example usage with a custom object
class ReusableConnection(var url: String = "") : PooledObject<ReusableConnection> {
    override fun reset(): ReusableConnection {
        url = "" // Reset state
        return this
    }
}

fun main() {
    val connectionPool = ObjectPool(::ReusableConnection)

    // Acquire connections and use them
    val connection1 = connectionPool.acquire()
    connection1.url = "https://example.com"
    // Use connection1

    // Release connections back to the pool
    connectionPool.release(connection1)

    // Acquire a new connection (might be the same instance)
    val connection2 = connectionPool.acquire()
    // Use connection2

    connectionPool.release(connection2)
}
