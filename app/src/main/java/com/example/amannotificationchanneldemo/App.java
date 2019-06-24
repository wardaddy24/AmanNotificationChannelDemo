package com.example.amannotificationchanneldemo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.ApplicationInfo;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        // This method will run before any other method as this is a application class.
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        //Checking SDK version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //Code for channel_1
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel-1",
                    NotificationManager.IMPORTANCE_HIGH);

            channel1.setDescription("This is Channel 1");

            // Code for channel_2
            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel-1",
                    NotificationManager.IMPORTANCE_LOW);

            channel2.setDescription("This is Channel 2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            //Ignoring notificationManager to be null.Can add a condition for checking

            notificationManager.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel2);

        }
    }
}