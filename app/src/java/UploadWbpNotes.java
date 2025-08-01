package com.example.notifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UploadWbpNotes extends AppCompatActivity {

    ListView myPDFListView6;
    DatabaseReference databaseReference6;
    List<UserHelperClass6> uploadPDFs6;
    FloatingActionButton fab;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_wbp_notes);

        myPDFListView6 = (ListView) findViewById(R.id.myListView);
        uploadPDFs6= new ArrayList<UserHelperClass6>(); //  uploadPDFs = new ArrayList< >();
        fab = (FloatingActionButton)findViewById(R.id.fab);
        drawerLayout = findViewById(R.id.drawer_layout2);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadWbpNotes.this, AddWbpNotes.class);
                startActivity(intent);
            }
        });

        viewAllFiles();

        myPDFListView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(UploadWbpNotes.this, "File opening", Toast.LENGTH_SHORT).show();

                UserHelperClass6 helperClass6 = uploadPDFs6.get(position);

                //opening selected file
                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(helperClass6.getUrl6()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles() {
        databaseReference6 = FirebaseDatabase.getInstance().getReference("WBP");
        databaseReference6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    UserHelperClass6 helperClass6 = postSnapshot.getValue(com.example.notifyme.UserHelperClass6.class);
                    uploadPDFs6.add(helperClass6);
                }

                String [] uploads = new String[uploadPDFs6.size()];

                for (int i = 0; i < uploads.length; i++){
                    uploads[i] = uploadPDFs6.get(i).getNameofpdf6();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads){
                    //                    @NonNull
//                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);
                        TextView myText = (TextView)view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);

                        return view;
                    }
                };
                // storing the pdfs in listView
                myPDFListView6.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
        Intent intent = new Intent(UploadWbpNotes.this, StaffViewpg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, StaffTimetablePg.class);
        startActivity(intent);
    }

    public void uploadSchedule(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, UpdateSchedulePg.class);
        startActivity(intent);
    }

    public void uploadNotes(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, UploadWbpNotes.class);
        startActivity(intent);
    }

    public void reverseChanges(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, StaffReverseChangesPg.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(UploadWbpNotes.this, LogoutPg.class);
        startActivity(intent);
    }

}