package com.natiqhaciyef.kotlinandroidknowledges.android.tools.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.natiqhaciyef.kotlinandroidknowledges.R


object AppNotification {
    val ID = "main_notification"
    val channel = NotificationChannel(
        ID, "Main Channel", NotificationManager.IMPORTANCE_DEFAULT
    )

    fun provideNotificationBuilder(notificationModel: NotificationModel, context: Context) =
        NotificationCompat.Builder(context, ID)
            .setContentTitle(notificationModel.title)
            .setContentText(notificationModel.description)
            .setSmallIcon(R.drawable.app_ring)
//            .setShortcutId("non selected")
//            .setVibrate(longArrayOf(0))
//            .setSound("".toUri())
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()


    fun provideNotificationManagerChannel(context: Context): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat
            .from(context)
        notificationManager.createNotificationChannel(channel)

        return notificationManager
    }

}