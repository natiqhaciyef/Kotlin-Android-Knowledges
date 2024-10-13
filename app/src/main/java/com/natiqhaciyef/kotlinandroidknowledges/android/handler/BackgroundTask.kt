package com.natiqhaciyef.kotlinandroidknowledges.android.handler

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper

class BackgroundTask: Thread() {

    val handlerThread = HandlerThread("Background Task").apply {
        start()
    }


    override fun run() {
        Looper.prepare()

        val handler = Handler(Looper.myLooper()!!) {
            println("Task is executed ${it.what}")
            true
        }


        handler.sendEmptyMessage(1)
        handler.sendEmptyMessage(2)
        handler.sendEmptyMessage(3)

        Looper.loop()
    }
}