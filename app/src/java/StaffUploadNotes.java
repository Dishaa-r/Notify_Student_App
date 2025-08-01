package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffUploadNotes extends AppCompatActivity {

    Button Mgt, Pwp, Mad, Eti, Wbp, Ede;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_upload_notes);

        drawerLayout = findViewById(R.id.drawer_layout2);

        Mgt = (Button)findViewById(R.id.Mgt);
        Pwp = (Button)findViewById(R.id.Pwp);
        Mad = (Button)findViewById(R.id.Mad);
        Eti = (Button)findViewById(R.id.Eti);
        Wbp = (Button)findViewById(R.id.Wbp);
        Ede = (Button)findViewById(R.id.Ede);

        Mgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffUploadNotes.this, UploadMgtNotes.class);
                startActivity(intent);
            }
        });

        Pwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffUploadNotes.this, UploadPwpNotes.class);
                startActivity(intent);
            }
        });

        Mad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffUploadNotes.this, UploadMadNotes.class);
                startActivity(intent);
            }
        });

        Eti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffUploadNotes.this, UploadEtiNotes.class);
                startActivity(intent);
            }
        });

        Wbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffUploadNotes.this, UploadWbpNotes.class);
                startActivity(intent);
            }
        });

        Ede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffUploadNotes.this, UploadEdeNotes.class);
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
        Intent intent = new Intent(StaffUploadNotes.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, StaffUploadNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StaffUploadNotes.this, LogoutPg.class);
        startActivity(intent);
    }

}