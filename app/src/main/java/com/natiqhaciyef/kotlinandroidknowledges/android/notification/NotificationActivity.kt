package com.natiqhaciyef.kotlinandroidknowledges.android.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0

        binding.buttonSend.setOnClickListener {
            if (count % 2 == 0)
//                displayNotification()
                displayNotificationWithLockScreen()
            else
                updateNotification()
            count += 1
        }

        binding.buttonEnd.setOnClickListener {
           cancelNotification()
        }

    }

    private fun displayNotification() {
        val notificationMessage = NotificationModel(
            title = "From Techtive.az",
            description = "Salam dostlar, bu gun Android development telemindeyik",
            smallIcon = 0,
            largeIcon = 0
        )
        AppNotification.provideNotificationManagerChannel(this@NotificationActivity)
            .notify(
                1,
                AppNotification.provideNotificationBuilder(
                    notificationMessage,
                    this@NotificationActivity
                )
            )

    }

    // update notification with same id, same channel
    private fun updateNotification() {
        val notificationMessage = NotificationModel(
            title = "New Techtive vacancy",
            description = "Mobile Developer vacancy",
            smallIcon = 0,
            largeIcon = 0
        )
        AppNotification.provideNotificationManagerChannel(this@NotificationActivity)
            .notify(
                1,
                AppNotification.provideNotificationBuilder(
                    notificationMessage,
                    this@NotificationActivity
                )
            )

    }

    // new notification with same channel, different id
    private fun newNotification() {
        val notificationMessage = NotificationModel(
            title = "New Techtive vacancy",
            description = "Mobile Developer vacancy",
            smallIcon = 0,
            largeIcon = 0
        )
        AppNotification.provideNotificationManagerChannel(this@NotificationActivity)
            .notify(
                1,
                AppNotification.provideNotificationBuilder(
                    notificationMessage,
                    this@NotificationActivity
                )
            )

    }

    private fun cancelNotification() {
        AppNotification.provideNotificationManagerChannel(this@NotificationActivity)
            .cancel(1)
    }

    private fun displayNotificationWithLockScreen(){
        val notificationMessage = NotificationModel(
            title = "From Techtive.az",
            description = "Salam dostlar, bu gun Android development telemindeyik",
            smallIcon = 0,
            largeIcon = 0
        )
        AppNotification.provideNotificationManagerChannel(this@NotificationActivity)
            .notify(
                1,
                AppNotification.provideNotificationBuilderWithLockScreen(
                    notificationMessage,
                    this@NotificationActivity
                )
            )
    }
}
