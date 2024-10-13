package com.natiqhaciyef.kotlinandroidknowledges.android.handler

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.MessageQueue
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.natiqhaciyef.kotlinandroidknowledges.R

class HandlerTestActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper()) {
        val operation = it.data.getString("name")
        println("Main operation: $operation")
        true
    }
    private val runTaskRunnable = Runnable {
        println("Task running...")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_handler_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        handler.post(runTaskRunnable)

        val backgroundTask = BackgroundTask()
        backgroundTask.start()

        val secondHandler = Handler(backgroundTask.handlerThread.looper) { msg ->
            val url = msg.data.getString("url")
            println("Processing URL in background: $url")
            val customMsg = handler.obtainMessage().apply {
                val data = Bundle()
                data.putString("name", "example")
                this.data = data
            }
            handler.sendMessage(customMsg)

            true
        }

        val msg = secondHandler.obtainMessage().apply {
            val data = Bundle().apply {
                putString("url", "https://example.com/data")
            }
            this.data = data
        }

        secondHandler.sendMessage(msg)
    }
}