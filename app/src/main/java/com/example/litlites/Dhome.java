package com.example.litlites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Dhome extends AppCompatActivity {

    private ImageView AddRetailer;
    private ImageView AddStock;
    private ImageView Stock;
    private ImageView Exit;
    private ImageView ListOfRetailers;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhome);

        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AddRetailer = (ImageView) findViewById(R.id.Order);
        AddStock = (ImageView) findViewById(R.id.Replace);
        Stock = (ImageView) findViewById(R.id.Stock);
        ListOfRetailers = (ImageView) findViewById(R.id.Lists);
        progressDialog = new ProgressDialog(this);
        Exit = (ImageView) findViewById(R.id.DLogout);

        firebaseAuth = FirebaseAuth.getInstance();


        AddRetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait");
                progressDialog.show();
                Intent intent = new Intent(Dhome.this, AddRetailer.class);
                startActivity(intent);
                progressDialog.dismiss();
            }
        });

        AddStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait");
                progressDialog.show();
                Intent intent = new Intent(Dhome.this, AddStocks.class);
                startActivity(intent);
                progressDialog.dismiss();
            }
        });
        Stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait");
                progressDialog.show();
                Intent intent = new Intent(Dhome.this, StockBook.class);
                startActivity(intent);
                progressDialog.dismiss();

            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(Dhome.this, Dlogin.class);
                startActivity(intent);

            }
        });
        ListOfRetailers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait");
                progressDialog.show();
                Intent intent = new Intent(Dhome.this, RetailersList.class);
                startActivity(intent);
                progressDialog.dismiss();
            }
        });

    }
}