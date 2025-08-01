package com.example.notifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class StaffAjayCTT extends AppCompatActivity {

//    private ScaleGestureDetector scaleGestureDetector;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_ajay_ctt);

        drawerLayout = findViewById(R.id.drawer_layout2);
    }

    public void ClickMenu2(View view) {openDrawer(drawerLayout);
    }

    private  void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, StaffUploadNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StaffAjayCTT.this, LogoutPg.class);
        startActivity(intent);
    }

}