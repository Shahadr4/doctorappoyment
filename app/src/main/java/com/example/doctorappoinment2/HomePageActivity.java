package com.example.doctorappoinment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Doc> doctorList;
    DocAdapter docAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //Toast.makeText(this, "Homepage Running", Toast.LENGTH_SHORT).show();
        recyclerView =findViewById(R.id.rvStudentsList);
        doctorList=new ArrayList<>();
        db.collection("doctors")

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@androidx.annotation.NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.e("TAG", document.getId() + " => " + document.getData());

                                Doc doctorFromDb=document.toObject(Doc.class);
                                setDocAdapter(doctorFromDb);

                            }
                        } else {
                            Log.e("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });






        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toast.makeText(this, "Homepage Running", Toast.LENGTH_SHORT).show();



    }
    void setDocAdapter(Doc doctorFromDb){
        Doc doc=new Doc();
        doc.setName(doctorFromDb.getName());
        doc.setSpecialization(doctorFromDb.getName());
        doctorList.add(doc);
        docAdapter = new DocAdapter(doctorList);
        recyclerView.setAdapter(docAdapter);

    }

}