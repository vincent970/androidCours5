package com.cba533.cours5.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.cba533.cours5.MainActivity;
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

    public static Notification createNotificationForImportantMessage(Context context, MessageModel message){
        //Intent intent = new Intent();
        //val pendingIntent :PendingIntent = PendingIntent.getActivity(MainActivity.class, 0,)
        //PendingIntent pendingIntent = PendingIntent.getActivity(, 0,intent,0)
        Intent readIntent = new Intent(this, MainActivity.class);
        //readIntent.setAction()
        PendingIntent readPendingIntent = PendingIntent.getBroadcast(this,0,readIntent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "42")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(message.getSender())
                .setContentText(message.getMessage())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.common_google_signin_btn_icon_dark_normal, "Marquer comme lu", );
        return builder.build();
    }
}
