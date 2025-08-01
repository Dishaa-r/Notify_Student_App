package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentStudyMaterial extends AppCompatActivity {

    Button Mgt, Pwp, Mad, Eti, Wbp, Ede;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_study_material);

        Mgt = (Button)findViewById(R.id.Mgt);
        Pwp = (Button)findViewById(R.id.Pwp);
        Mad = (Button)findViewById(R.id.Mad);
        Eti = (Button)findViewById(R.id.Eti);
        Wbp = (Button)findViewById(R.id.Wbp);
        Ede = (Button)findViewById(R.id.Ede);

        drawerLayout = findViewById(R.id.drawer_layout1);

        Mgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentStudyMaterial.this, ViewMgtNotes.class);
                startActivity(intent);
            }
        });

        Pwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentStudyMaterial.this, ViewPwpNotes.class);
                startActivity(intent);
            }
        });

        Mad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentStudyMaterial.this, ViewMadNotes.class);
                startActivity(intent);
            }
        });

        Eti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentStudyMaterial.this, ViewEtiNotes.class);
                startActivity(intent);
            }
        });

        Wbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentStudyMaterial.this, ViewWbpNotes.class);
                startActivity(intent);
            }
        });

        Ede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentStudyMaterial.this, ViewEdeNotes.class);
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
        Intent intent = new Intent(StudentStudyMaterial.this, StudentViewPg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StudentStudyMaterial.this, StudentStudyMaterial.class);
        startActivity(intent);
    }

    public void studyMaterial(View view)
    {
        Intent intent = new Intent(StudentStudyMaterial.this, StudentStudyMaterial.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StudentStudyMaterial.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StudentStudyMaterial.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StudentStudyMaterial.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StudentStudyMaterial.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StudentStudyMaterial.this, LogoutPg.class);
        startActivity(intent);
    }

}