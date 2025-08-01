package com.example.notifyme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddEtiNotes extends AppCompatActivity {

    EditText filename;
    Button upload;
    StorageReference storageReference;
    DatabaseReference databaseReference2;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eti_notes);

        filename = (EditText)findViewById(R.id.filename);
        upload = (Button)findViewById(R.id.upload);
        drawerLayout = findViewById(R.id.drawer_layout2);

        //initialising db and storage vars
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference2 = FirebaseDatabase.getInstance().getReference("ETI");

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {selectPDFFile();}

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
        Intent intent = new Intent(AddEtiNotes.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, AddEtiNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void terms(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(AddEtiNotes.this, LogoutPg.class);
        startActivity(intent);
    }


    private void selectPDFFile() {
        Intent intent = new Intent(); // to pick pdf files
//        intent.setType("application/pdf");
        intent.setType("*/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Select file"), 2);
        // it will read the selected file in firebase
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null){
            uploadFile(data.getData());
        }
    }

    private void uploadFile(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        StorageReference reference = storageReference.child("ETI/"+System.currentTimeMillis());
        // store data in storage
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            // called when pdf will be stored in db n then store data
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                while (!uri.isComplete());
                Uri url = uri.getResult();// storing url in url var/ obj

                UserHelperClass2 helperClass2 = new UserHelperClass2(filename.getText().toString(),url.toString());
                databaseReference2.child(databaseReference2.push().getKey()).setValue(helperClass2);
                Toast.makeText(AddEtiNotes.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();

                progressDialog.setMessage("Uploaded : "+(int)progress +"%");
            }
        });
    }
}