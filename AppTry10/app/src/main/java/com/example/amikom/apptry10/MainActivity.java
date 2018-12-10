package com.example.amikom.apptry10;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotif(View view) {
        NotificationManagerCompat myManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder myNoti = new NotificationCompat.Builder(this);
        myNoti.setContentTitle("1 New Message");
        myNoti.setContentText("Hi How Are You?");
        myNoti.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent il = new Intent(this,MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this,1,il,0);
        myNoti.setContentIntent(pd);
        myNoti.setAutoCancel(true);

        myManager.notify(1,myNoti.build());

        finish();

    }
}
