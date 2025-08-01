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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewEdeNotes extends AppCompatActivity {

    ListView myPDFListView1;
    DatabaseReference databaseReference1;
    List<UserHelperClass1> uploadPDFs1;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ede_notes);


        myPDFListView1 = (ListView) findViewById(R.id.myListView);
        uploadPDFs1= new ArrayList<UserHelperClass1>(); //  uploadPDFs = new ArrayList< >();
        drawerLayout = findViewById(R.id.drawer_layout1);

        viewAllFiles();

        myPDFListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(ViewEdeNotes.this, "File opening", Toast.LENGTH_SHORT).show();

                UserHelperClass1 helperClass1 = uploadPDFs1.get(position);

                //opening selected file
                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(helperClass1.getUrl1()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles() {
        databaseReference1 = FirebaseDatabase.getInstance().getReference("EDE");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    UserHelperClass1 helperClass1 = postSnapshot.getValue(com.example.notifyme.UserHelperClass1.class);
                    uploadPDFs1.add(helperClass1);
                }

                String [] uploads = new String[uploadPDFs1.size()];

                for (int i = 0; i < uploads.length; i++){
                    uploads[i] = uploadPDFs1.get(i).getNameofpdf1();
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
                myPDFListView1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void ClickMenu(View view) {openDrawer(drawerLayout);
    }

    private  void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void home(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, StudentViewPg.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, StudentTimetablePg.class);
        startActivity(intent);
    }

    public void studyMaterial(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, StudentStudyMaterial.class);
        startActivity(intent);
    }

    public void privacyPolicy(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, PrivacyPolicyPg.class);
        startActivity(intent);
    }

    public void help(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, Help.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, Share.class);
        startActivity(intent);
    }

    public void rate(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, Rate.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent = new Intent(ViewEdeNotes.this, LogoutPg.class);
        startActivity(intent);
    }

}