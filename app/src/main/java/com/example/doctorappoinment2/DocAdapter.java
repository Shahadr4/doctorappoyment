package com.example.doctorappoinment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DocAdapter extends RecyclerView.Adapter<DocAdapter.ViewHolder> {
    List<Doc> doctorList;

    public DocAdapter(List<Doc> doctorList) {
        this.doctorList = doctorList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocAdapter.ViewHolder holder, int position) {
        Doc doctorData= doctorList.get(position);
        holder.txtName.setText(doctorData.getName());
        holder.txtEmail.setText(doctorData.getSpecialization());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });


    }



    @Override
    public int getItemCount() {
        return doctorList.size();
    }



    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView txtName;
        TextView txtEmail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.textView7);
            txtEmail = itemView.findViewById(R.id.textView8);
        }
    }


//    List<Doctor> doctorList;
//    ItemCallback callback;
//
//    public DocAdapter(List<Doctor> doctorList) {
//        this.doctorList = doctorList;
//        //this.callback = callback;
//    }
//
//    @NonNull
//    @Override
//    public DocAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).
//                inflate(R.layout.listview,parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DocAdapter.ViewHolder holder, int position) {
//        Doctor studentsData= doctorList.get(position);
//        holder.name.setText(studentsData.getDrname());
//        holder.depar.setText(studentsData.getDpartment());
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                return false;
//            }
//        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return doctorList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView name;
//        TextView depar;
//            public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//                name = itemView.findViewById(R.id.textView7);
//                depar = itemView.findViewById(R.id.textView8);
//
//
//        }
//    }
}
