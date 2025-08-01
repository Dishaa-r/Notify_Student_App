package com.example.notifyme;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class broadcast_receiver extends BroadcastReceiver {
    //    public broadcast_receiver(){ }
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "inside on receive node day"+node+day, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "inside on receive", Toast.LENGTH_SHORT).show();
//        Toast.makeText(context, "n value"+n+t1, Toast.LENGTH_SHORT).show();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("CO1");
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("CO2");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    @SuppressLint("SimpleDateFormat") Format f = new SimpleDateFormat("EEEE");
                    String day = f.format(new Date());
                    day=day.toUpperCase();
                    System.out.println("Day Name: "+day);
                    int i=1;
//                    int i=2;
                    String node=String.valueOf(i);
                    System.out.println("String : "+ node);
                    Toast.makeText(context, "inside on data change", Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "node day"+node+day, Toast.LENGTH_SHORT).show();
                    System.out.println("node day: "+node+day);

//                    //For lecture---------------------------------------------------------------------------------------
                    String lecture = "Lecture : " + dataSnapshot.child(day).child(node).child("lecture").getValue() + "\n";
                    String time = "Time : " + dataSnapshot.child(day).child(node).child("time").getValue() + "\n";
                    String faculty = "Faculty : " + dataSnapshot.child(day).child(node).child("faculty").getValue() + "\n";
                    String classno = "Class No : " + dataSnapshot.child(day).child(node).child("classno").getValue() + "\n";
                    String notify = time +lecture+faculty+ classno;

//                    For practical---------------------------------------------------------------------------------------
//                    String practical = "Practical : " + dataSnapshot.child(day).child(node).child("A").child("practical").getValue() + "\n";
//                    String ptime = "Time : " + dataSnapshot.child(day).child(node).child("A").child("time").getValue() + "\n";
//                    String pfaculty = "Faculty : " + dataSnapshot.child(day).child(node).child("A").child("faculty").getValue() + "\n";
//                    String labno = "Lab No : " + dataSnapshot.child(day).child(node).child("A").child("labno").getValue() + "\n";
//                    String notify = ptime  +practical+pfaculty+ labno;

//                    String practical = "Practical : " + dataSnapshot.child("MONDAY").child(node).child("A").child("practical").getValue() + "\n";
//                    String ptime = "Time : " + dataSnapshot.child("MONDAY").child(node).child("A").child("time").getValue() + "\n";
//                    String pfaculty = "Faculty : " + dataSnapshot.child("MONDAY").child(node).child("A").child("faculty").getValue() + "\n";
//                    String labno = "Lab No : " + dataSnapshot.child("MONDAY").child(node).child("A").child("labno").getValue() + "\n";
//                    String notify = ptime  +practical+pfaculty+ labno;




                    Toast.makeText(context, "inside on data change abv notific", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder ncb = new NotificationCompat.Builder(context, "01");
                    ncb.setSmallIcon(R.drawable.notifylogo);
                    ncb.setContentTitle("Notification");
                    ncb.setContentText("Reminder : \n"+notify);
                    Toast.makeText(context, notify, Toast.LENGTH_SHORT).show();
                    ncb.setStyle(new
                            NotificationCompat.BigTextStyle().bigText(notify));
                    NotificationManagerCompat nmc = NotificationManagerCompat.from(context);

                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    nmc.notify(1, ncb.build());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}