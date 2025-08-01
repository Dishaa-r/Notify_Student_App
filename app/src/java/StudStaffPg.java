package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudStaffPg extends AppCompatActivity {

    Button RegAsStudbtn;
    Button RegAsStaffbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_staff_pg);

        RegAsStudbtn = findViewById(R.id.RegAsStudbtn);
        RegAsStaffbtn = findViewById(R.id.RegAsStaffbtn);

        RegAsStudbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudStaffPg.this, StudentLoginPage.class);
                startActivity(intent);
            }
        });

        RegAsStaffbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudStaffPg.this, StaffLoginPage.class);
                startActivity(intent);
            }
        });
    }
}