package com.natiqhaciyef.kotlinandroidknowledges.android.handler

import java.util.concurrent.LinkedBlockingQueue
import android.os.Message


class MessageQueue {

    private val queue = LinkedBlockingQueue<Message>()

    private val thread = Thread {
        try {
            while (!Thread.currentThread().isInterrupted) {
                val message = queue.take()
                handleMessage(message)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    init {
        thread.start()
    }

    fun enqueueMessage(message: Message) {
        queue.put(message)
    }

    private fun handleMessage(message: Message) {
        when (message.what) {
            1 -> {
                val data = message.obj as? String
                println("Handling message with data: $data")
            }
            else -> {
                println("Unknown message type: ${message.what}")
            }
        }
    }

    fun stop() {
        thread.interrupt()
    }
}
