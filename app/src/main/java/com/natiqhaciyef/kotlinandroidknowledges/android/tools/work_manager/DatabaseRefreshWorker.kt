package com.natiqhaciyef.kotlinandroidknowledges.android.tools.work_manager

import android.content.Context
import android.content.SharedPreferences
import androidx.work.Worker
import androidx.work.WorkerParameters

class DatabaseRefreshWorker(val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    val DB_NAME = "MyDatabase"
    override fun doWork(): Result {
        val data = inputData.getInt("key", 0)
        refreshDatabase(data)
        return Result.success()
    }

    private fun refreshDatabase(data: Int) {
        val sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE)
        var savedNumber = sharedPreferences.getInt("Data", 0)
        savedNumber += data
        println(savedNumber)
        sharedPreferences.edit().putInt("Data", savedNumber).apply()
    }

}