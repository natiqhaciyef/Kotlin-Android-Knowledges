package com.natiqhaciyef.kotlinandroidknowledges.android.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class DownloadWorker(
    context: Context,
    workerParams: WorkerParameters
): Worker(context, workerParams) {
    override fun doWork(): Result {
        try {

            for (i in 0..10000){
                println("Downloading $i")
            }

            return Result.success()
        }catch (e: Exception) {
            return Result.failure()
        }
    }
}