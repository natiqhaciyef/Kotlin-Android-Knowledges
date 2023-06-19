package com.natiqhaciyef.kotlinandroidknowledges.android.notification

data class NotificationModel(
    var title: String,
    var description: String,
    var smallIcon: Int = 0,
    var largeIcon: Int = 0,
)