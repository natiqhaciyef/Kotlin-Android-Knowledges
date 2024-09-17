package com.natiqhaciyef.kotlinandroidknowledges.android.work_manager

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivitySecondWorkManagerBinding

class SecondWorkManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondWorkManagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startButtonWorkManager.setOnClickListener {
            workManagerAction()
        }
    }

    private fun workManagerAction(){
        val workManager = WorkManager.getInstance(application)

        val workRequest1 = OneTimeWorkRequestBuilder<DownloadWorker>().build()
        val workRequest2 = OneTimeWorkRequestBuilder<CombinatorWorker>().build()

        val list = mutableListOf(workRequest1, workRequest2)

        workManager.enqueue(list)

        workManager.getWorkInfoByIdLiveData(workRequest1.id)
            .observe(this) {
                binding.textViewWorkManager.text = "Text: ${it.state.name}"
            }
    }
}
