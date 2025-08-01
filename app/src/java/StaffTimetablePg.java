package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffTimetablePg extends AppCompatActivity {

    Button Vaghela, Amrita, Garud, Sangeeta, Chawda, Seema, Bhosale, Mokashi, Anurrag;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_timetable_pg);

        drawerLayout = findViewById(R.id.drawer_layout2);

        Vaghela = (Button)findViewById(R.id.Vaghela);
        Amrita = (Button)findViewById(R.id.Amrita);
        Garud = (Button)findViewById(R.id.Garud);
        Sangeeta = (Button)findViewById(R.id.Sangeeta);
        Chawda = (Button)findViewById(R.id.Chawda);
        Seema = (Button)findViewById(R.id.Seema);
        Bhosale = (Button)findViewById(R.id.Bhosale);
        Mokashi = (Button)findViewById(R.id.Mokashi);
        Anurrag = (Button)findViewById(R.id.Anurrag);


        Vaghela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffParvezVTT.class);
                startActivity(intent);
            }
        });

        Amrita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffAmritaRTT.class);
                startActivity(intent);
            }
        });

        Garud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffRajeshGTT.class);
                startActivity(intent);
            }
        });

        Sangeeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffSangeetaKTT.class);
                startActivity(intent);
            }
        });

        Chawda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffAjayCTT.class);
                startActivity(intent);
            }
        });

        Seema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffSeemaKTT.class);
                startActivity(intent);
            }
        });

        Bhosale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffBhosleSTT.class);
                startActivity(intent);
            }
        });

        Mokashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffMokashiTT.class);
                startActivity(intent);
            }
        });

        Anurrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffTimetablePg.this, StaffAnuragRTT.class);
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
        Intent intent = new Intent(StaffTimetablePg.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, StaffUploadNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StaffTimetablePg.this, LogoutPg.class);
        startActivity(intent);
    }
}