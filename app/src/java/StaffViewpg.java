package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffViewpg extends AppCompatActivity {

    Button buttonTT, buttonUS, buttonUN, buttonRC;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_viewpg);

        buttonTT = (Button)findViewById(R.id.buttonTT);
        buttonUS = (Button)findViewById(R.id.buttonUS);
        buttonUN = (Button)findViewById(R.id.buttonUN);
        buttonRC = (Button)findViewById(R.id.buttonRC);

        drawerLayout = findViewById(R.id.drawer_layout2);

        buttonTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffViewpg.this, StaffTimetablePg.class);
                startActivity(intent);
            }
        });

        buttonUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffViewpg.this, UpdateSchedulePg.class);
                startActivity(intent);
            }
        });

        buttonUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffViewpg.this, StaffUploadNotes.class);
                startActivity(intent);
            }
        });

        buttonRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffViewpg.this, StaffReverseChangesPg.class);
                startActivity(intent);
            }
        });

    }

    public void ClickMenu2(View view) {openDrawer(drawerLayout);
    }

    private  void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, StaffUploadNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StaffViewpg.this, LogoutPg.class);
        startActivity(intent);
    }

}