package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentTimetablePg extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button co1btn;
    Button co2btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_timetable_pg);

        drawerLayout = findViewById(R.id.drawer_layout1);
        co1btn = findViewById(R.id.co1btn);
        co2btn = findViewById(R.id.co2btn);

        co1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentTimetablePg.this, StudentTTCO1.class);
                startActivity(intent);
            }
        });

        co2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentTimetablePg.this, StudentTTCO2.class);
                startActivity(intent);
            }
        });
    }
    public void ClickMenu(View view) {openDrawer(drawerLayout);
    }

    private  void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, StudentViewPg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, StudentTimetablePg.class);
        startActivity(intent);
    }

    public void studyMaterial(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, StudentStudyMaterial.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StudentTimetablePg.this, LogoutPg.class);
        startActivity(intent);
    }

}