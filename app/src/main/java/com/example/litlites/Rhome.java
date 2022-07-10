package com.example.litlites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class Rhome extends AppCompatActivity {
    
    private ImageView Exit;
    private ImageView CheckStock;
    private ImageView Contact; 
    private ImageView AboutUs;
    private  ImageView PlaceOrder;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhome);

        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        firebaseAuth = FirebaseAuth.getInstance();
        Exit = (ImageView) findViewById(R.id.RLogout);
        CheckStock = (ImageView) findViewById(R.id.CheckStock);
        Contact = (ImageView) findViewById(R.id.Contact);
        AboutUs = (ImageView) findViewById(R.id.About);
        PlaceOrder = (ImageView) findViewById(R.id.Order);

        CheckStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rhome.this, StockBook.class);
                startActivity(intent);


            }
        });

        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rhome.this, ContactUs.class);
                startActivity(intent);

            }
        });

        AboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rhome.this, AboutUs.class);
                startActivity(intent);

            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(Rhome.this, Rlogin.class);
                startActivity(intent);

            }
        });

        PlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rhome.this, AddToCart.class);
                startActivity(intent);

            }
        });


    }
}