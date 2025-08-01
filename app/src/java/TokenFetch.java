package com.example.notifyme;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;

public class TokenFetch extends AppCompatActivity {

    DatabaseReference reference;
    Button fetchToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token_fetch);

        fetchToken = (Button) findViewById(R.id.fetchToken);

        fetchToken.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (task.isSuccessful()) {
                            String token = task.getResult();
                            Log.d(TAG, "onComplete: Token: " + token);
                            DatabaseReference tokenRef = FirebaseDatabase.getInstance().getReference().child("CO1Tokens");
                            tokenRef.push().setValue(token);
                            Toast.makeText(TokenFetch.this, "token  : " + token, Toast.LENGTH_LONG).show();
//                    mOutputText.setText("Token Generated" + token);
                        }

                    }
                });

                reference = FirebaseDatabase.getInstance().getReference();
                reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                DataSnapshot dataSnapshot = task.getResult();

                                for (int i = 0; i <= 70; i++) {
                                    String token = dataSnapshot.child("CO1Tokens").child(String.valueOf(i)).getValue(String.class);
                                    Toast.makeText(TokenFetch.this, "token : "+token, Toast.LENGTH_LONG).show();
                                    //pushNotification(token);
                                }
                            }
                        }
                    }


                });
            }
        });
    }
}