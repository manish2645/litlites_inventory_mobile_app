package com.example.litlites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddStocks extends AppCompatActivity {

    private Button Cancel;
    private Button Add;
    EditText Item_code,Item_name,Types,Watt,Quantity,Rates;
    private ProgressDialog progressDialog;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stocks);

        getSupportActionBar().setTitle("Add Stock");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Cancel = (Button) findViewById(R.id.btnCancel);
        Add = (Button) findViewById(R.id.btnAdd);
        Item_code = (EditText)findViewById(R.id.Icode);
        Item_name = (EditText)findViewById(R.id.Iname);
        Types = (EditText)findViewById(R.id.Types);
        Watt = (EditText)findViewById(R.id.Watt);
        Quantity = (EditText)findViewById(R.id.Quantity);
        Rates = (EditText)findViewById(R.id.Rates);
        progressDialog = new ProgressDialog(this);

        progressDialog = new ProgressDialog(this);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Stocks");

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddStocks.this,Dhome.class);
                startActivity(intent);
            }
        });
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait");
                progressDialog.show();
                insertStocks();
                startActivity(new Intent(AddStocks.this,Dhome.class));
            }
        });
    }

    private void insertStocks() {
        String code = Item_code.getText().toString();
        String iname = Item_name.getText().toString();
        String types = Types.getText().toString();
        String watt = Watt.getText().toString();
        String qty = Quantity.getText().toString();
        String rates = Rates.getText().toString();
        if(code.isEmpty() && iname.isEmpty() && types.isEmpty()){
            Toast.makeText(AddStocks.this,"Please enter all the details!",Toast.LENGTH_LONG).show();
        }else {
            Stocks stocks = new Stocks(code, iname, types, watt, qty, rates);
            databaseReference.push().setValue(stocks);
            progressDialog.dismiss();
            Toast.makeText(AddStocks.this, "Item Added!", Toast.LENGTH_LONG).show();
        }

    }
}