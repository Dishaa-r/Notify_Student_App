package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class StaffRegPg extends AppCompatActivity {

    EditText phone;
    EditText name;
    EditText password;
    Button register;

    FirebaseDatabase rootnode;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_reg_pg);

        phone = findViewById(R.id.phone);
        name=findViewById(R.id.name);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!validatePassword() | !validatePhoneNo() | !validateUsername())
                {
                    return;
                }

                rootnode = FirebaseDatabase.getInstance();
                reference=rootnode.getReference().child("Staff");

                //Get all the values
                String phno2=phone.getText().toString();
                String name2=name.getText().toString();
                String pwd2=password.getText().toString();

                UserHelperClass helperClass=new UserHelperClass(phno2,name2,pwd2);

                reference.child(phno2).setValue(helperClass);

//                Second method to store data
                HashMap<String,String> userMap=new HashMap<>();
                userMap.put("Phone",phno2);
                userMap.put("Name",name2);
                userMap.put("Password",pwd2);
                reference.child(phno2).setValue(userMap);

                Toast.makeText(StaffRegPg.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();

                // direct to login pg 2
                Intent intent = new Intent(StaffRegPg.this, StaffViewpg.class);
                startActivity(intent);

            }
        });
    }

    private Boolean validatePhoneNo() {
        String val = phone.getText().toString();
        if (val.isEmpty()) {
            phone.setError("Field cannot be empty");
            return false;
        }
        else if (val.length() < 10 || val.length() > 10) {
            phone.setError("Enter 10 digit Mobile Number");
            return  false;
        }
        else
        {
            phone.setError(null);
//            phone.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
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
//            password.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername()
    {
        String val = name.getText().toString();
        String nameregexp = "^[a-zA-Z. ]*[a-zA-Z. ]*[a-zA-Z. ]*$";
//        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (val.isEmpty()) {
            name.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            name.setError("Username too long");
            return false;
        } else if (!val.matches(nameregexp)) {
            name.setError("no special characters allowed");
            return false;
        } else {
            name.setError(null);
            return true;
        }
    }
}