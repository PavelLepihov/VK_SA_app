package com.example.falcon_ab.vk_sa_app.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.model.Place;
import com.example.falcon_ab.vk_sa_app.ui.activity.OpenedPostFromPushActivity;

import java.util.Date;

public class NotificationHelper {

    public static final int DEFAULT_SMALL_ICON = R.drawable.baseline_message_black_24;

    public static void notify(Context context, PushModel pushModel) {

        if (pushModel == null) {
            return;
        }


        int mId = (int) new Date().getTime();

        int smallIcon = pushModel.getIcon() != 0 ? pushModel.getIcon() : DEFAULT_SMALL_ICON;


        String title = (pushModel.getFirstName() != null || pushModel.getLastName() != null) ?
                (pushModel.getFirstName() + " " + pushModel.getLastName())
                : context.getResources().getString(R.string.vk_group_default_name);

        String text = pushModel.getText() != null ?
                pushModel.getText() : context.getResources().getString(R.string.message);

        switch (pushModel.getType()) {
            case FcmMessage.TYPE_REPLY :
                title += " отвечает:";
                break;
            case FcmMessage.TYPE_COMMENT :
                title += " комментирует:";
                break;
            case FcmMessage.TYPE_NEW_POST :
                title += " новая запись на стене";
                break;
        }

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(smallIcon)
                        .setContentTitle(title)
                        .setContentText(text)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setAutoCancel(true);
        Intent resultIntent = new Intent(context, OpenedPostFromPushActivity.class);

        resultIntent.putExtra(Place.PLACE, pushModel.getPlace().toBundle());

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(OpenedPostFromPushActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId, mBuilder.build());

    }

}
