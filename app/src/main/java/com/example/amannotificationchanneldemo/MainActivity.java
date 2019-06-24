package com.example.amannotificationchanneldemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.amannotificationchanneldemo.App.CHANNEL_1_ID;
import static com.example.amannotificationchanneldemo.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat mNotificationManagerCompat;
    private EditText mEditTextTitle;
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManagerCompat = NotificationManagerCompat.from(this);

        mEditTextTitle = findViewById(R.id.edit_text_title);
        mEditTextMessage = findViewById(R.id.edit_text_message);

    }
    public void sendonChannel1(View v){
        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();
        Intent intent = new Intent(this , MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, intent,0);
        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", message);
        PendingIntent broadcastPendingIntent =
                PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap largeicon = BitmapFactory.decodeResource(getResources(),R.drawable.testimage);



        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                                    .setSmallIcon(R.drawable.ic_notifications1)
                                    .setContentTitle(title)
                                    .setContentText(message)
                                    .setLargeIcon(largeicon)
                                    .setStyle(new NotificationCompat.BigTextStyle()
                                            .bigText("bTO TOT TOO TTOT TTOT OT TO TTO T T " +
                                                    "fngkrjgierjgeirgierngirengiergirngirngirngirngirngringirngirngirngringrgnrgnrigrpo" +
                                                    "rgnrgnrgnrigrigjrgnrkgnrkgnrgknrgknrgknrgkrkgOTTOTOTOTOT TOT TOTOTOOTOTOTOTOTOOTOTFNFDNJDNVDJLVNDJVNJLVNDVNDVNDN")
                                            .setSummaryText("This is summary text")
                                            .setBigContentTitle("bigContent"))
                                    .setColor(Color.BLUE)
                                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                                    .setContentIntent(pendingIntent)
                                    .addAction(R.mipmap.ic_launcher,"Toast",broadcastPendingIntent)
                                    .setAutoCancel(true)
                                    .setOnlyAlertOnce(true)
                                    .build();

        mNotificationManagerCompat.notify(1,notification);
    }
    public void sendonChannel2(View v){
        String title = mEditTextTitle.getText().toString();
        String message = mEditTextMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_email2)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(new NotificationCompat.InboxStyle()
                .addLine("This is  line 1")
                 .addLine("This is  line 2")
                 .addLine("This is  line 3")
                 .addLine("This is  line 4")
                 .addLine("This is line 5 ")
                                .setSummaryText("This is summary text")
                                .setBigContentTitle("bigContent")
                  )
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        mNotificationManagerCompat.notify(2,notification);

    }
}
