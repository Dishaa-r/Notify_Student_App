package com.example.notifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class StaffLoginPage extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    TextView signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login_page);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateUsername() | !validatePassword()) {
                    return;
                } else {
                    isUser();
                }
            }

            private void isUser() {
//                progressBar.setVisibility(View.VISIBLE);
                final String userEnteredUsername = username.getText().toString().trim();
                final String userEnteredPassword = password.getText().toString().trim();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Staff");
                Query checkUser = reference.orderByChild("Phone").equalTo(userEnteredUsername);

                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            username.setError(null);
//                            username.setErrorEnabled(false);
                            String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("Phone").getValue(String.class);
                            String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("Password").getValue(String.class);

                            if (passwordFromDB.equals(userEnteredPassword)) {
                                username.setError(null);
//                                username.setErrorEnabled(false);
                                String nameFromDB = dataSnapshot.child(userEnteredUsername).child("Name").getValue(String.class);
//                                String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
//                                String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
//                                String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
//                                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
//                                intent.putExtra("name", nameFromDB);
//                                intent.putExtra("username", usernameFromDB);
//                                intent.putExtra("email", emailFromDB);
//                                intent.putExtra("phoneNo", phoneNoFromDB);
//                                intent.putExtra("password", passwordFromDB);
//                                startActivity(intent);

                                Toast.makeText(StaffLoginPage.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(StaffLoginPage.this, StaffViewpg.class);
                                startActivity(intent);

                            } else {
//                                progressBar.setVisibility(View.GONE);
                                password.setError("Wrong Password");
                                password.requestFocus();
                            }
                        } else {
//                            progressBar.setVisibility(View.GONE);
                            username.setError("No such User exist");
                            username.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffLoginPage.this, StaffRegPg.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validatePassword() {
        String val = password.getText().toString();
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
//            password.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = username.getText().toString();
        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else {
            username.setError(null);
//            username.setErrorEnabled(false);
            return true;
        }
    }
}