package com.example.litlites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {

    private ImageView AddToCart, ViewCart, OrderPlace, Details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        AddToCart = (ImageView) findViewById(R.id.AddCart);
        ViewCart = (ImageView) findViewById(R.id.ViewCart);
        OrderPlace = (ImageView) findViewById(R.id.PlaceOrder);
        Details = (ImageView) findViewById(R.id.OrderDetails);

        AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetails.this, AddToCart.class));
            }
        });

    }
}