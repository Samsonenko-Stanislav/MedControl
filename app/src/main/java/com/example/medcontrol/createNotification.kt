package com.example.medcontrol

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*

@SuppressLint("MissingPermission")
fun createNotification(context: Context, medicineName: String, time: String) {
    // Создание канала уведомлений (для Android 8.0+)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "medicine_channel"
        val channelName = "Medicine Reminders"
        val channelDescription = "Channel for medicine reminders"
        val importance = NotificationManager.IMPORTANCE_DEFAULT

        val channel = NotificationChannel(channelId, channelName, importance).apply {
            description = channelDescription
        }

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    // Создание уведомления
    val notificationBuilder = NotificationCompat.Builder(context, "medicine_channel")
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle("Time to take medicine")
        .setContentText("It's time to take your $medicineName")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)

    val notificationId = Random().nextInt()
    val notificationManager = NotificationManagerCompat.from(context)
    notificationManager.notify(notificationId, notificationBuilder.build())
}