package com.example.litlites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddRetailer extends AppCompatActivity {

    private EditText Code;
    private EditText ShopName;
    private EditText FirstName;
    private EditText LastName;
    private EditText Address;
    private EditText Email;
    private EditText Password;
    private Button Cancel;
    private Button Add;

    private FirebaseDatabase database;
    private DatabaseReference mdatabase;
    private FirebaseFirestore firestore;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private static final String USER = "user";
    private static final String TAG = "AddRetailer";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_retailer);

        getSupportActionBar().setTitle("Add Retailer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        database = FirebaseDatabase.getInstance();
        mdatabase = database.getReference(USER);

        Code = (EditText) findViewById(R.id.Rcode);
        ShopName = (EditText) findViewById(R.id.Shop);
        FirstName = (EditText) findViewById(R.id.Fname);
        LastName = (EditText) findViewById(R.id.Lname);
        Address = (EditText) findViewById(R.id.Address);
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Rpassword);
        Cancel = (Button) findViewById(R.id.btnCancel);
        Add = (Button) findViewById(R.id.btnAdd);


        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRetailer.this,Dhome.class);
                startActivity(intent);
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait");
                progressDialog.show();
               /* if(validate()){
                    String user_email = Username.getText().toString().trim();
                    String user_pass = Password.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {
                                        progressDialog.dismiss();
                                        Toast.makeText(AddRetailer.this, "Registration Successful", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(AddRetailer.this,Dhome.class));
                                    }else{
                                        progressDialog.dismiss();
                                        Toast.makeText(AddRetailer.this, "Registration Failed", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }*/
                    String code = Code.getText().toString();
                    String email = Email.getText().toString();
                    String pass = Password.getText().toString();
                    if(TextUtils.isEmpty(code) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
                        Toast.makeText(getApplicationContext(), "Enter All the Fields!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    String sname = ShopName.getText().toString();
                    String fname = FirstName.getText().toString();
                    String lname = LastName.getText().toString();
                    String address = Address.getText().toString();
                    user = new User(code,sname,fname,lname,address,email,pass);
                    RegisterRetailer(email, pass);
            }

        });

    }
   /** private Boolean validate(){
        Boolean result = false;
        String name = Username.getText().toString();
        String pass = Password.getText().toString();
        if(name.isEmpty() && pass.isEmpty()){
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_LONG).show();
        }else{
            result =true;
        }
        return result;
    }*/
    public void RegisterRetailer(String email, String pass){
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmailAndPassword:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmailAndPassword:failure", task.getException());
                            Toast.makeText(AddRetailer.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
    public void updateUI(FirebaseUser currentUser){
        String keyId = mdatabase.push().getKey();
        mdatabase.child(keyId).setValue(user);
        Intent intent = new Intent(AddRetailer.this,Dhome.class);
        startActivity(intent);
    }
}