package com.example.litlites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CheckStocks extends AppCompatActivity {

    ListView myListView;
    List<Stocks> stocksList;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_book);

        getSupportActionBar().setTitle("Stocks Available");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myListView = findViewById(R.id.mylistView);
        stocksList = new ArrayList<>();


        databaseReference = FirebaseDatabase.getInstance().getReference("Stocks");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stocksList.clear();

                for (DataSnapshot stockDatasnap : dataSnapshot.getChildren()) {
                    Stocks stocks = stockDatasnap.getValue(Stocks.class);
                    stocksList.add(stocks);
                }
                ListAdaptor adaptor = new ListAdaptor(CheckStocks.this, stocksList);
                myListView.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CheckStocks.this, "Retrieve Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}