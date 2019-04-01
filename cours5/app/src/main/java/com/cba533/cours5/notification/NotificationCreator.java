package com.cba533.cours5.notification;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.cba533.cours5.R;
import com.cba533.cours5.notification.model.MessageModel;

public class NotificationCreator {
    public static Notification createNotificationForMessage(Context context, MessageModel message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "42")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(message.getSender())
                .setContentText(message.getMessage())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }
}
