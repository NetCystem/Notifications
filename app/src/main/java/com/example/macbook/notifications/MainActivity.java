package com.example.macbook.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                simple_not();
//                inbox_not();
//                inbox_not2();
                inbox_not3();

            }
        });


    }


    public void simple_not(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder (this);

        builder.setContentTitle("this is title")
                .setContentText("Text")
                .setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }



    public void inbox_not(){
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        inboxStyle.setBigContentTitle("Title")
                .addLine("message1")
                .addLine("message2")
                .addLine("message3")
                .setSummaryText("+2 more...");

        NotificationCompat.Builder builder = new NotificationCompat.Builder (this);
        builder.setContentTitle("this is title")
                .setContentText("Text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(inboxStyle);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }


    public void inbox_not2(){
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                (int) Calendar.getInstance().getTimeInMillis(),intent,0);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        inboxStyle.setBigContentTitle("Title")
                .addLine("message1")
                .addLine("message2")
                .addLine("message3")
                .setSummaryText("+2 more...");

        NotificationCompat.Builder builder = new NotificationCompat.Builder (this);
        builder.setContentTitle("this is title")
                .setContentText("Text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(inboxStyle)
                .addAction(R.mipmap.ic_launcher, "GO", pendingIntent);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }



    public void inbox_not3(){
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                (int) Calendar.getInstance().getTimeInMillis(),intent,0);


        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle("Title")
                .bigText("hgjhghjghkgjkgkblkbl");

        NotificationCompat.Builder builder = new NotificationCompat.Builder (this);
        builder.setContentTitle("this is title")
                .setContentText("Text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(bigTextStyle)
                .addAction(R.mipmap.ic_launcher, "GO", pendingIntent);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());
    }
}
