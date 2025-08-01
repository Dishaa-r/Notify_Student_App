package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
//    Button button;
    private static final long DELAY_TIME_MS = 4000;

    PendingIntent pending_intent;
    AlarmManager alarm_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toast.makeText(MainActivity.this, "on create function", Toast.LENGTH_SHORT).show();
        notification_channel();
//        Toast.makeText(MainActivity.this, "outside notification_channel funct", Toast.LENGTH_SHORT).show();
        pending_intent = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(this, broadcast_receiver.class), PendingIntent.FLAG_IMMUTABLE);
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

//---------------------------------------------------------------
//        Calendar cal = Calendar.getInstance();
//creating a constructor of the SimpleDateFormat class
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date=new Date();

//displaying full-day name
        @SuppressLint("SimpleDateFormat") Format f = new SimpleDateFormat("EEEE");
        String day = f.format(new Date());
//prints day name
//        System.out.println("Day Name: "+day);

        switch (day.toUpperCase())
        {
            case "MONDAY":{
                switch (sdf.format(date))
                {
                    case "08:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "09:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "10:55":
                    {

                        set_notification_alarm(60*60*1000);

                    }
                    case "11:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "12:55":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "01:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "02:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }


                }
            }
            case "TUESDAY":{
                switch (sdf.format(date))
                {
                    case "08:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "09:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "10:55":
                    {

                        set_notification_alarm(60*60*1000);

                    }
                    case "11:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "12:55":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "01:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "02:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }


                }
            }
            case "WEDNESDAY":{
                switch (sdf.format(date))
                {
                    case "08:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "09:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "10:55":
                    {

                        set_notification_alarm(60*60*1000);

                    }
                    case "11:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "12:55":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "01:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "02:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }


                }
            }
            case "THURSDAY":{
                switch (sdf.format(date))
                {
                    case "08:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "09:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "10:55":
                    {

                        set_notification_alarm(60*60*1000);

                    }
                    case "11:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "12:55":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "01:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "02:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }


                }
            }
            case "FRIDAY":{
//                Toast.makeText(MainActivity.this, "inside switch case wednesday", Toast.LENGTH_SHORT).show();

                switch (sdf.format(date)){
                    case "03:33":{
//                        Toast.makeText(MainActivity.this, "inside time switch 3:30" +sdf.format(date) , Toast.LENGTH_SHORT).show();;
                        System.out.println("inside time switch 3:33");
                        set_notification_alarm(60);
                        break;
                    }
                    default:{
//                        Toast.makeText(MainActivity.this, "inside default" +sdf.format(date) , Toast.LENGTH_SHORT).show();
                        set_notification_alarm(60);
                        break;
                    }
                }
            }

            case "SATURDAY":{
                switch (sdf.format(date))
                {
                    case "08:55":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "09:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "10:33":
                    {

                        set_notification_alarm(60*60*1000);

                    }
                    case "11:55":
                    {

                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "12:55":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "01:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    case "02:25":
                    {
                        set_notification_alarm(60*60*1000);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }
                    default:
                    {
                        set_notification_alarm(60);
//                        new broadcast_receiver(node, day.toUpperCase());
                    }



                }


            }
        }

//        button = findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, StudStaffPg.class);
//                startActivity(intent);
//            }
//        });



        ImageView image;
        image = findViewById(R.id.bellimg);

        ImageView img;
        img = findViewById(R.id.notifymeimg);

        Animation animationTop = AnimationUtils.loadAnimation(this, R.anim.animation_top);
        image.setAnimation(animationTop);

        Animation animationBottom = AnimationUtils.loadAnimation(this, R.anim.animation_bottom);
        img.setAnimation(animationBottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, StudStaffPg.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_TIME_MS);

    }


    public void set_notification_alarm(long interval) {
//        alarm_manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pending_intent);
        long t = System.currentTimeMillis()+interval;
        alarm_manager.setExact(AlarmManager.RTC_WAKEUP,t,pending_intent);
//        Toast.makeText(this, "inside alarm manager,set noti", Toast.LENGTH_SHORT).show();
    }
    private void notification_channel() {
//        Toast.makeText(MainActivity.this, "inside notification_channel funct", Toast.LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel("01", "XYZ", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(nc);
        }
    }
}
