package com.example.litlites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {

    Context context;

    ArrayList<User> list;


    public MyAdaptor(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.code.setText(user.getCode());
        holder.shopName.setText(user.getShopName());
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.address.setText(user.getAddress());
        holder.email.setText(user.getEmail());
        holder.password.setText(user.getPassword());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView code,shopName,firstName, lastName, address, email,password;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            code = itemView.findViewById(R.id.tvCode);
            shopName = itemView.findViewById(R.id.Shop);
            firstName = itemView.findViewById(R.id.tvfirstName);
            lastName = itemView.findViewById(R.id.tvlastName);
            address = itemView.findViewById(R.id.tvAddress);
            email = itemView.findViewById(R.id.tvEmail);
            password = itemView.findViewById(R.id.tvPassword);

        }
    }

}
