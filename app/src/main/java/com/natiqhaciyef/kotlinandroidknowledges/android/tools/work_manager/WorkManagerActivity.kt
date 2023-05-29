package com.natiqhaciyef.kotlinandroidknowledges.android.tools.work_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityWorkManagerBinding
import java.time.Duration
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWorkManagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = Data.Builder().putInt("key", 1).build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(false)
            .setRequiresDeviceIdle(false)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<DatabaseRefreshWorker>()
            .setConstraints(constraints)
            .setInputData(data)
            .addTag("Worker 1")
            .setInitialDelay(5, TimeUnit.MINUTES)
            .build()

        val periodicWorkRequest =
            PeriodicWorkRequestBuilder<DatabaseRefreshWorker>(Duration.ofMinutes(15))
                .setConstraints(constraints)
                .setInputData(data)
                .build()

        WorkManager.getInstance(this).enqueue(periodicWorkRequest)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.id)
            .observe(this) { workInfo ->
                println(workInfo.state == WorkInfo.State.ENQUEUED)
            }

        WorkManager.getInstance(this).cancelWorkById(periodicWorkRequest.id)

        WorkManager.getInstance(this).beginWith(workRequest)
            .then(workRequest).enqueue()
    }
}