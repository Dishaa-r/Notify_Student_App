package com.example.notifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaffReverseChangesPg extends AppCompatActivity {

    DrawerLayout drawerLayout;
    EditText reversecode;
    String revCode;
    Button reverseChange;
    DatabaseReference reference3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_reverse_changes_pg);

        drawerLayout = findViewById(R.id.drawer_layout2);
        reversecode = (EditText) findViewById(R.id.reversecode);
        reversecode.setTextIsSelectable(true);
        reverseChange = (Button) findViewById(R.id.reverseChange);

        reverseChange.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(validateRevKey()){
                    revCode = reversecode.getText().toString();

                    reference3 = FirebaseDatabase.getInstance().getReference("BackUpData");

                    reference3.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if(task.isSuccessful()){
                                if(task.getResult().exists()){
                                    DataSnapshot dss = task.getResult();

                                    Toast.makeText(StaffReverseChangesPg.this, "rev code : " +revCode, Toast.LENGTH_LONG).show();

                                    String __time = String.valueOf(dss.child(revCode).child("time").getValue());
                                    String __classno = String.valueOf(dss.child(revCode).child("classno").getValue());
                                    String __labno = String.valueOf(dss.child(revCode).child("labno").getValue());
                                    String __lecture = String.valueOf(dss.child(revCode).child("lecture").getValue());
                                    String __practical = String.valueOf(dss.child(revCode).child("practical").getValue());
                                    String __faculty = String.valueOf(dss.child(revCode).child("faculty").getValue());
                                    String __class = String.valueOf(dss.child(revCode).child("class").getValue());
                                    String __batch = String.valueOf(dss.child(revCode).child("batch").getValue());
                                    String __day = String.valueOf(dss.child(revCode).child("day").getValue());
                                    String __node = String.valueOf(dss.child(revCode).child("node").getValue());

                                    Toast.makeText(StaffReverseChangesPg.this, "prev time" +__time, Toast.LENGTH_LONG).show();
                                    Toast.makeText(StaffReverseChangesPg.this, "prev classno" +__classno, Toast.LENGTH_LONG).show();
                                    Toast.makeText(StaffReverseChangesPg.this, "prev lectu" +__lecture, Toast.LENGTH_LONG).show();
                                    Toast.makeText(StaffReverseChangesPg.this, "prev factyly" +__faculty, Toast.LENGTH_LONG).show();
                                    Toast.makeText(StaffReverseChangesPg.this, "prev class" +__class, Toast.LENGTH_LONG).show();
                                    Toast.makeText(StaffReverseChangesPg.this, "prev node" +__node, Toast.LENGTH_LONG).show();
                                    Toast.makeText(StaffReverseChangesPg.this, "prev day" +__day, Toast.LENGTH_LONG).show();


                                    Pattern pattern = Pattern.compile("_BATCH", Pattern.CASE_INSENSITIVE);
                                    Matcher matcher = pattern.matcher(revCode);
                                    boolean matchFound = matcher.find();
                                    if(matchFound) {
                                        HashMap<String,Object> clonedDB=new HashMap<>();
                                        clonedDB.put("time",__time);
                                        clonedDB.put("practical",__practical);
                                        clonedDB.put("faculty",__faculty);
                                        clonedDB.put("labno",__labno);

                                        reference3 = FirebaseDatabase.getInstance().getReference(__class);
                                        reference3.child(__day).child(__node).child(__batch).updateChildren(clonedDB).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(StaffReverseChangesPg.this, "Reversed Successfully", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    Toast.makeText(StaffReverseChangesPg.this, "Reverse Failed", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    } else {
                                        HashMap<String,Object> clonedDB=new HashMap<>();
                                        clonedDB.put("time",__time);
                                        clonedDB.put("lecture",__lecture);
                                        clonedDB.put("faculty",__faculty);
                                        clonedDB.put("classno",__classno);

                                        reference3 = FirebaseDatabase.getInstance().getReference(__class);
                                        reference3.child(__day).child(__node).updateChildren(clonedDB).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(StaffReverseChangesPg.this, "Reversed Successfully", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    Toast.makeText(StaffReverseChangesPg.this, "Reverse Failed", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }
                                else{
                                    Toast.makeText(StaffReverseChangesPg.this, "Data doesn't exits", Toast.LENGTH_LONG).show();
                                }
                            }
                            else{
                                Toast.makeText(StaffReverseChangesPg.this, "Failed to read", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private boolean validateRevKey() {
        String val = reversecode.getText().toString();
        if (val.isEmpty()) {
            reversecode.setError("Please enter Reverse Code");
            return false;
        }
        else {
            reversecode.setError(null);
            return true;
        }
    }

    public void ClickMenu2(View view) {openDrawer(drawerLayout);
    }

    private  void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, StaffUploadNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(StaffReverseChangesPg.this, LogoutPg.class);
        startActivity(intent);
    }

}