package app.messanger.my.mymessanger;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

import android.support.v7.app.NotificationCompat;
import android.content.Intent;
import android.app.PendingIntent;
import android.media.RingtoneManager;
import android.graphics.Color;
import android.content.Context;
import android.net.Uri;


/**
 * Created by burovg on 16/11/2016.
 */

public class MyMessagesListener extends GcmListenerService {

    @Override
    public void onMessageReceived(String from,Bundle data){
        Log.d("messanger","Message received");
        String msg =  data.getString("key1");
        sendNotification(msg);
    }

    public MyMessagesListener() {
    }

    private void sendNotification(String message) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,

                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase Test")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        //notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());*/

        //Color color = Color.GREEN;

        /*NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setContentText("Test")
                //.setSmallIcon(R.mipmap.ic_skylight_notification)
                .setContentTitle("Test")
                .setColor(Color.GREEN)
                .setContentIntent(pendingIntent);*/

        //NotificationManager notificationManager =
         //       (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0,notificationBuilder.build());


    }
}
