package com.example.dwis.notificationlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String CHANNELID="Personal Information";
    private  final int  NotificationID=001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displaynotification(View view) {
        createnotificationchannel();
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,CHANNELID);
        builder.setSmallIcon(R.drawable.ic_sms_notification);
        builder.setContentTitle("LOGIN Notification");
        builder.setContentText("You are successfully logged on");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NotificationID,builder.build());
    }
    private  void createnotificationchannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name="personal notification";
            String description="Include all the personal notifications";
            int importancce= NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel= new NotificationChannel(CHANNELID,name,importancce);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }
}
