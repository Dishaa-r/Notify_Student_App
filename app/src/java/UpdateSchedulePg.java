package com.example.notifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UpdateSchedulePg extends AppCompatActivity {

    DrawerLayout drawerLayout;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    DatabaseReference reference1;

    EditText lab_class;
    Spinner time;
    Spinner class1;
    Spinner batch;
    Spinner subject;
    Spinner faculty;
    Spinner day;
    int periodNo;
    String reverseKey;
    Button applychange;
    TextView reverseChange;

    List<Integer> FlagArray = new ArrayList<Integer>(Collections.nCopies(6, 0));

    private void validateDay() {
        if(String.valueOf(getItem(day)) == "Select Day"){
            FlagArray.set(1,0);
            Toast.makeText(UpdateSchedulePg.this, "Please select day", Toast.LENGTH_SHORT).show();
        }
        else{
            FlagArray.set(1,1);
        }
    }

    private void validateRoom() {
        String val = lab_class.getText().toString();
        if (val.isEmpty()) {
            lab_class.setError("Please enter Lab/ Class No");
            FlagArray.set(5, 0);
        }
        else {
            lab_class.setError(null);
            FlagArray.set(5, 1);
        }
    }

    private void validateFaculty() {
        if(String.valueOf(getItem(faculty)) == "Select Faculty"){
            FlagArray.set(4,0);
            Toast.makeText(UpdateSchedulePg.this, "Please select faculty", Toast.LENGTH_SHORT).show();
        }
        else{
            FlagArray.set(4,1);
        }
    }

    private void validateSubject() {
        if(String.valueOf(getItem(subject)) == "Select Subject"){
            FlagArray.set(3,0);
            Toast.makeText(UpdateSchedulePg.this, "Please select Subject", Toast.LENGTH_SHORT).show();
        }
        else{
            FlagArray.set(3,1);
        }
    }
    private void validateClass() {
        if(String.valueOf(getItem(class1)) == "Select Class"){
            FlagArray.set(2,0);
            Toast.makeText(UpdateSchedulePg.this, "Please select class", Toast.LENGTH_SHORT).show();
        }
        else{
            FlagArray.set(2,1);
        }
    }

    private void validateTime() {
        if(String.valueOf(getItem(time)) == "Select Time"){
            FlagArray.set(0,0);
            Toast.makeText(UpdateSchedulePg.this, "Please select time", Toast.LENGTH_SHORT).show();
        }
        else{
            FlagArray.set(0,1);
        }
    }

    private void updateLecture(String time, String day, String class1, String subject, String faculty, String lab_class) {

        switch (time){
            case "09:00-10:00":
            {
                periodNo = 1;
                break;
            }
            case "10:00-11:00":
            {
                periodNo = 2;
                break;
            }
            case "11:00-12:00":
            {
                periodNo = 3;
                break;
            }
            case "12:00-01:00":
            {
                periodNo = 4;
                break;
            }
            case "01:30-02:30":
            {
                periodNo = 5;
                break;
            }
            case "02:30-03:30":
            {
                periodNo = 6;
                break;
            }
            case "03:30-04:30":
            {
                periodNo = 7;
                break;
            }

        }

        reference1 = FirebaseDatabase.getInstance().getReference("BackUpData");
        reference = FirebaseDatabase.getInstance().getReference();

        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        DataSnapshot dss = task.getResult();

                        String __time = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child("time").getValue());
                        String __classno = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child("classno").getValue());
                        String __lecture = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child("lecture").getValue());
                        String __faculty = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child("faculty").getValue());


                        Toast.makeText(UpdateSchedulePg.this, "prev time" +__time, Toast.LENGTH_LONG).show();
                        Toast.makeText(UpdateSchedulePg.this, "prev classno" +__classno, Toast.LENGTH_LONG).show();
                        Toast.makeText(UpdateSchedulePg.this, "prev lectu" +__lecture, Toast.LENGTH_LONG).show();
                        Toast.makeText(UpdateSchedulePg.this, "prev factyly" +__faculty, Toast.LENGTH_LONG).show();


                        HashMap<String,String> cloneDB=new HashMap<>();
                        cloneDB.put("time",__time);
                        cloneDB.put("lecture",__lecture);
                        cloneDB.put("faculty",__faculty);
                        cloneDB.put("classno",__classno);
                        cloneDB.put("class",class1);
                        cloneDB.put("day",day);
                        cloneDB.put("node", String.valueOf(periodNo));

                        String reverseKey = reference1.push().getKey();
                        assert reverseKey != null;
                        reference1.child(reverseKey).setValue(cloneDB);
                        Toast.makeText(UpdateSchedulePg.this, "reve key " +reverseKey, Toast.LENGTH_LONG).show();

                        String __revkey = String.valueOf(dss.child("BackUpData").getValue());
                        reverseChange.setText(__revkey);

                        Toast.makeText(UpdateSchedulePg.this, "about to update the data", Toast.LENGTH_SHORT).show();

                        HashMap<String,Object> userMap=new HashMap<>();
                        userMap.put("time",time);
                        userMap.put("lecture",subject);
                        userMap.put("faculty",faculty);
                        userMap.put("classno",lab_class);
                        reference = FirebaseDatabase.getInstance().getReference(class1);
                        reference.child(day).child(String.valueOf(periodNo)).updateChildren(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    reverseChange.setText(reverseKey);
                                    Toast.makeText(UpdateSchedulePg.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(UpdateSchedulePg.this, "Update Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                    else{
                        Toast.makeText(UpdateSchedulePg.this, "Data doesn't exits", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(UpdateSchedulePg.this, "Failed to read", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void updateBatch(String time, String day, String class1, String batch, String subject, String faculty, String lab_class) {
        switch (time){
            case "09:00-10:00":
            {
                periodNo = 1;
                break;
            }
            case "10:00-11:00":
            {
                periodNo = 2;
                break;
            }
            case "11:00-12:00":
            {
                periodNo = 3;
                break;
            }
            case "12:00-01:00":
            {
                periodNo = 4;
                break;
            }
            case "01:30-02:30":
            {
                periodNo = 5;
                break;
            }
            case "02:30-03:30":
            {
                periodNo = 6;
                break;
            }
            case "03:30-04:30":
            {
                periodNo = 7;
                break;
            }

        }

        reference1 = FirebaseDatabase.getInstance().getReference("BackUpData");

        reference = FirebaseDatabase.getInstance().getReference();
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        DataSnapshot dss = task.getResult();

                        String __time = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child(batch).child("time").getValue());
                        String __labno = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child(batch).child("labno").getValue());
                        String __practical = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child(batch).child("practical").getValue());
                        String __faculty = String.valueOf(dss.child(class1).child(day).child(String.valueOf(periodNo)).child(batch).child("faculty").getValue());

                        Toast.makeText(UpdateSchedulePg.this, "prev time" +__time, Toast.LENGTH_LONG).show();
                        Toast.makeText(UpdateSchedulePg.this, "prev classno" +__labno, Toast.LENGTH_LONG).show();
                        Toast.makeText(UpdateSchedulePg.this, "prev lectu" +__practical, Toast.LENGTH_LONG).show();
                        Toast.makeText(UpdateSchedulePg.this, "prev factyly" +__faculty, Toast.LENGTH_LONG).show();


                        HashMap<String,String> cloneDB=new HashMap<>();
                        cloneDB.put("time",__time);
                        cloneDB.put("practical",__practical);
                        cloneDB.put("faculty",__faculty);
                        cloneDB.put("labno",__labno);
                        cloneDB.put("class",class1);
                        cloneDB.put("batch",batch);
                        cloneDB.put("day",day);
                        cloneDB.put("node", String.valueOf(periodNo));

                        String reverseKey = reference1.push().getKey()+"_BATCH";
                        assert reverseKey != null;
                        reference1.child(reverseKey).setValue(cloneDB);
                        Toast.makeText(UpdateSchedulePg.this, "reve key " +reverseKey, Toast.LENGTH_LONG).show();

                        String __revkey = String.valueOf(dss.child("BackUpData").getValue());
                        reverseChange.setText(__revkey);


                        Toast.makeText(UpdateSchedulePg.this, "about to update the data", Toast.LENGTH_SHORT).show();

                        HashMap<String,Object> userMap2=new HashMap<>();
                        userMap2.put("time",time);
                        userMap2.put("practical",subject);
                        userMap2.put("faculty",faculty);
                        userMap2.put("labno",lab_class);
                        reference = FirebaseDatabase.getInstance().getReference(class1);
                        Toast.makeText(UpdateSchedulePg.this, "batch :" +batch, Toast.LENGTH_LONG).show();
                        reference.child(day).child(String.valueOf(periodNo)).child(batch).updateChildren(userMap2).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    reverseChange.setText(reverseKey);
                                    Toast.makeText(UpdateSchedulePg.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(UpdateSchedulePg.this, "Update Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                    else{
                        Toast.makeText(UpdateSchedulePg.this, "Data doesn't exits", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(UpdateSchedulePg.this, "Failed to read", Toast.LENGTH_LONG).show();
                }
            }
        });




        HashMap<String,Object> userMap=new HashMap<>();
        userMap.put("time",time);
        userMap.put("practical",subject);
        userMap.put("faculty",faculty);
        userMap.put("labno",lab_class);

        reference = FirebaseDatabase.getInstance().getReference(class1);
        reference.child(day).child(String.valueOf(periodNo)).child(batch).updateChildren(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(UpdateSchedulePg.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UpdateSchedulePg.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Object getItem(Spinner spinner) {
        return spinner.getSelectedItem();
    }

    public void ClickMenu2(View view) {openDrawer(drawerLayout);
    }

    private  void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, StaffUploadNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(UpdateSchedulePg.this, LogoutPg.class);
        startActivity(intent);
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_schedule_pg);
        drawerLayout = findViewById(R.id.drawer_layout2);

        lab_class=(EditText) findViewById(R.id.lab_class);
        reverseChange = findViewById(R.id.reverseCode);
        reverseChange.setTextIsSelectable(true);
        applychange=(Button) findViewById(R.id.applychange);

        applychange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateClass();
                validateDay();
                validateFaculty();
                validateRoom();
                validateSubject();
                validateTime();

                boolean allOne= true;
                System.out.println(FlagArray);
                for (int i = 0; i < FlagArray.size(); i++) {
                    if (FlagArray.get(i) == 0) {
                        allOne=false;
                        break;
                    }

                }

                if(allOne){

                    String _lab_class = lab_class.getText().toString();

                    String _time = String.valueOf(getItem(time));
                    String _class1 = String.valueOf(getItem(class1));
                    String _batch = String.valueOf(getItem(batch));
                    String _subject = String.valueOf(getItem(subject));
                    String _faculty = String.valueOf(getItem(faculty));
                    String _day = String.valueOf(getItem(day));

                    if(_batch == "Select Batch"){
                        updateLecture(_time, _day, _class1, _subject, _faculty, _lab_class);
                    }
                    else{
                        updateBatch(_time, _day, _class1, _batch, _subject, _faculty, _lab_class);
                    }

                }
            }
        });

        time = findViewById(R.id.time);
        ArrayList<String> arrayList6 = new ArrayList<>();
        arrayList6.add("Select Time");
        arrayList6.add("09:00-10:00");
        arrayList6.add("10:00-11:00");
        arrayList6.add("11:00-12:00");
        arrayList6.add("12:00-01:00");
        arrayList6.add("01:30-02:30");
        arrayList6.add("02:30-03:30");
        arrayList6.add("03:30-04:30");
        ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList6);
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time.setAdapter(arrayAdapter6);

        class1 = findViewById(R.id.class1);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Select Class");
        arrayList1.add("CO1");
        arrayList1.add("CO2");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        class1.setAdapter(arrayAdapter1);

        batch = findViewById(R.id.batch);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Select Batch");
        arrayList2.add("A");
        arrayList2.add("B");
        arrayList2.add("C");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        batch.setAdapter(arrayAdapter2);

        subject = findViewById(R.id.subject);
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Select Subject");
        arrayList3.add("PWP");
        arrayList3.add("WBP");
        arrayList3.add("MAD");
        arrayList3.add("ETI");
        arrayList3.add("EDE");
        arrayList3.add("MGT");
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject.setAdapter(arrayAdapter3);


        faculty = findViewById(R.id.faculty);
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Select Faculty");
        arrayList4.add("Rajesh Garud");
        arrayList4.add("Seema Kaimal");
        arrayList4.add("Amrita Rathod");
        arrayList4.add("Ajay Chawda");
        arrayList4.add("Parvez Vaghela");
        arrayList4.add("Anurag Rathod");
        arrayList4.add("Avinash Mokashi");
        arrayList4.add("Sangeeta Kasbe");
        arrayList4.add("Hanumant Bhosle");
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList4);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        faculty.setAdapter(arrayAdapter4);


        day = findViewById(R.id.day);
        ArrayList<String> arrayList5 = new ArrayList<>();
        arrayList5.add("Select Day");
        arrayList5.add("MONDAY");
        arrayList5.add("TUESDAY");
        arrayList5.add("WEDNESDAY");
        arrayList5.add("THURSDAY");
        arrayList5.add("FRIDAY");
        arrayList5.add("SATURDAY");
        ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList5);
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(arrayAdapter5);
    }
}