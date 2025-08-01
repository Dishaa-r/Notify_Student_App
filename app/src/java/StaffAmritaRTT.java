package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StaffAmritaRTT extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_amrita_rtt);

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
        Intent intent = new Intent(StaffAmritaRTT.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, StaffUploadNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StaffAmritaRTT.this, LogoutPg.class);
        startActivity(intent);
    }

}