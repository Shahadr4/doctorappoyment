package com.example.doctorappoinment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

public class LoginActivity extends AppCompatActivity {
    EditText mob,txtpass;
    Button btnLogin,goReg;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mob = findViewById(R.id.editTextTextPersonName);
        txtpass = findViewById(R.id.editTextTextPersonName2);
        btnLogin = findViewById(R.id.button);
        goReg = findViewById(R.id.button2);






        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!mob.getText().toString().isEmpty()){


                    DocumentReference docRef = db.collection("userDoc").document(mob.getText().toString());
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    Log.d("TAG", "DocumentSnapshot data: " + document.getData());
                                    User user=document.toObject(User.class);
                                    if(user.password.equals(txtpass.getText().toString())){
                                        Toast.makeText(LoginActivity.this, "Loged In", Toast.LENGTH_SHORT).show();
                                        Intent ho = new Intent(LoginActivity.this,HomePageActivity.class);
                                        startActivity(ho);


                                    }else {
                                        Toast.makeText(LoginActivity.this, "Password is Incorrect", Toast.LENGTH_SHORT).show();

                                    }
                                } else {
                                    Log.d("TAG", "No such document");

                                    Toast.makeText(LoginActivity.this, "incorrect", Toast.LENGTH_SHORT).show();

                                }
                            } else {
                                Log.d("TAG", "get failed with ", task.getException());
                            }
                        }
                    });

                }else{
                    Toast.makeText(LoginActivity.this, "Please enter your phonr number", Toast.LENGTH_SHORT).show();
                }





            }
        });




        //going to regiser page
        goReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);


            }
        });
    }
}