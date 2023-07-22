package com.example.doctorappoinment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText uname,uphone,upasword,email,conpawd;
    Spinner bloodgroup;
    Button reg,goLogin;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uname=findViewById(R.id.editTextTextPersonName3);
        uphone=findViewById(R.id.editTextTextPersonName4);
        email=findViewById(R.id.editTextTextPersonName5);
        upasword=findViewById(R.id.editTextTextPersonName6);
        conpawd=findViewById(R.id.editTextTextPersonName7);


       // spinner
         String[] bldgrp = { "A+","A-","B+","B-","AB+","AB-","O+","O-"};
         Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, bldgrp);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

        reg=findViewById(R.id.button3);
        goLogin=findViewById(R.id.button4);




        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(upasword.getText().toString().equals(conpawd.getText().toString())){

        Map<String, Object> userDoc = new HashMap<>();
        userDoc.put("name", uname.getText().toString());
        userDoc.put("phone_num", uphone.getText().toString());
        userDoc.put("email", email.getText().toString());

        userDoc.put("password", upasword.getText().toString());

        userDoc.put("blood_group", spinner.getSelectedItem().toString());



        // Add a new document with a generated ID
        db.collection( "userDoc").document(uphone.getText().toString())
        .set(userDoc)
        .addOnSuccessListener(new OnSuccessListener<Void>() {
@Override
public void onSuccess(Void aVoid) {

        Log.d("TAG", "DocumentSnapshot successfully written!");
        Toast.makeText(RegisterActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();
        Intent i= new Intent(RegisterActivity.this,HomePageActivity.class);
        startActivity(i);


        }
        })
        .addOnFailureListener(new OnFailureListener() {
@Override
public void onFailure(@NonNull Exception e) {
        Log.w("TAG", "Error writing document", e);
        }
        });
        }else {
        Toast.makeText(RegisterActivity.this, "please Correct your password", Toast.LENGTH_SHORT).show();}

            }

            }
        );






        //go to login
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegisterActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }


}