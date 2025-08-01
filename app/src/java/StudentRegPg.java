package com.example.notifyme;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentRegPg extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;
    EditText phone_No;
    EditText password;
    Button regButton;
    TextView LoginText;
    FirebaseDatabase rootnode;

    DatabaseReference reference;

    static int i = 0;
    static int j = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg_pg);

        phone_No = findViewById(R.id.phone_No);
        password = findViewById(R.id.password);
        regButton = findViewById(R.id.regButton);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!validatePassword() | !validatePhoneNo() | !validateClass() | !validateBatch())
                {
                    return;
                }
                rootnode = FirebaseDatabase.getInstance();
                reference=rootnode.getReference().child("Student");

                String phno2=phone_No.getText().toString();
                String pwd2=password.getText().toString();

                String text1=String.valueOf(getItem(spinner1));
                String text2=String.valueOf(getItem(spinner2));

                UserHelperClass helperClass=new UserHelperClass(phno2,pwd2,text1,text2);
                reference.child(phno2).setValue(helperClass);

//                Second method to store data
                HashMap<String,String> userMap=new HashMap<>();
                userMap.put("Phone",phno2);
                userMap.put("StudClass",text1);
                userMap.put("Batch",text2);
                userMap.put("Password",pwd2);
                reference.child(phno2).setValue(userMap);

                if(text1 == "TYCO1"){
                    FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (task.isSuccessful()) {
                                String token = task.getResult();
                                Log.d(TAG, "onComplete: Token: " + token);
                                DatabaseReference tokenRef= FirebaseDatabase.getInstance().getReference().child("CO1Tokens");

//                                tokenRef.child(String.valueOf(i)).setValue(token);
//                                i++;
//                                Toast.makeText(StudentRegPg.this, "token  : "+token, Toast.LENGTH_LONG).show();

                            }

                        }
                    });
                } else if (text1 == "TYCO2") {
                    FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (task.isSuccessful()) {
                                String token = task.getResult();
                                Log.d(TAG, "onComplete: Token: " + token);
                                DatabaseReference tokenRef= FirebaseDatabase.getInstance().getReference().child("CO2Tokens");

//                                tokenRef.child(String.valueOf(j)).setValue(token);
//                                j++;
//                                Toast.makeText(StudentRegPg.this, "token  : "+token, Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }


                Toast.makeText(StudentRegPg.this, "Successfully Registered!!", Toast.LENGTH_SHORT).show();
                
                Intent intent = new Intent(StudentRegPg.this, StudentViewPg.class);
                startActivity(intent);
            }
        });

        spinner1 = findViewById(R.id.spinner1);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Select Class");
        arrayList1.add("TYCO1");
        arrayList1.add("TYCO2");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);

        spinner2 = findViewById(R.id.spinner2);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Select Batch");
        arrayList2.add("A");
        arrayList2.add("B");
        arrayList2.add("C");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);

    }

    private Object getItem(Spinner spinner) {
        return spinner.getSelectedItem();
    }

    private Boolean validatePhoneNo() {
        String val = phone_No.getText().toString();
        if (val.isEmpty()) {
            phone_No.setError("Field cannot be empty");
            return false;
        }
        else if (val.length() < 10 || val.length() > 10) {
            phone_No.setError("Enter 10 digit Mobile Number");
            return  false;
        }
        else
        {
            phone_No.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getText().toString();
        String passwordVal = "^" +
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            password.setError("Password is too weak:\nPassword must contain Upper and Lower Case, Special Symbols and Number");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

    private Boolean validateClass() {
        if(String.valueOf(getItem(spinner1)) == "Select Class"){
            Toast.makeText(StudentRegPg.this, "Please select class", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private Boolean validateBatch() {
        if(String.valueOf(getItem(spinner2)) == "Select Batch"){
            Toast.makeText(StudentRegPg.this, "Please select batch", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

}