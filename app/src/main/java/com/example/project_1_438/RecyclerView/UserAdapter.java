package com.example.project_1_438.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_1_438.AdminActivity;
import com.example.project_1_438.AdminEditActivity;
import com.example.project_1_438.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{
    Context context;
    ArrayList<String> username;
    ArrayList<String> firstname;
    ArrayList<Integer> zip;
    ArrayList<String> password;

    public UserAdapter(Context context, ArrayList<String> username, ArrayList<String> firstname, ArrayList<Integer> zip, ArrayList<String> password) {
        this.context = context;
        this.username = username;
        this.firstname = firstname;
        this.zip = zip;
        this.password = password;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, final int position) {
        holder.fName.setText(firstname.get(position));
        holder.uName.setText(username.get(position));
        holder.zipcd.setText(String.valueOf(zip.get(position)));
        holder.passwrd.setText(password.get(position));

        holder.myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AdminEditActivity.intentFactory(context);
                intent.putExtra("USERNAME",username.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return firstname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView fName;
        TextView uName;
        TextView passwrd;
        TextView zipcd;
        ConstraintLayout myLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fName = itemView.findViewById(R.id.firsname_recy);
            uName = itemView.findViewById(R.id.username_recy);
            passwrd = itemView.findViewById(R.id.passord_recy);
            zipcd = itemView.findViewById(R.id.zip_recy);
            myLayout = itemView.findViewById(R.id.users_list);
        }
    }
}
