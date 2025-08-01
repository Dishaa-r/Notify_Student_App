package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentViewPg extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button StudTTBtn;
    Button NotesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_pg);

        drawerLayout = findViewById(R.id.drawer_layout1);
        StudTTBtn = findViewById(R.id.TTBtn);
        NotesBtn = findViewById(R.id.NotesBtn);

        StudTTBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentViewPg.this, StudentTimetablePg.class);
                startActivity(intent);
            }
        });

        NotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentViewPg.this, StudentStudyMaterial.class);
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
        Intent intent = new Intent(StudentViewPg.this, StudentViewPg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StudentViewPg.this, StudentTimetablePg.class);
        startActivity(intent);
    }

    public void studyMaterial(View view)
    {
        Intent intent = new Intent(StudentViewPg.this, StudentStudyMaterial.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StudentViewPg.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StudentViewPg.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StudentViewPg.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StudentViewPg.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StudentViewPg.this, LogoutPg.class);
        startActivity(intent);
    }

}