package com.example.litlites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Rlogin extends AppCompatActivity {

    private EditText Rcode, Username, Password;
    private Button Login;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlogin);

        getSupportActionBar().setTitle("Retailer Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Rcode = (EditText) findViewById(R.id.RCode);
        Username = (EditText) findViewById(R.id.REmail);
        Password = (EditText) findViewById(R.id.RPass);
        Login = (Button) findViewById(R.id.loginR);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        /*if(user != null){
            finish();
            startActivity(new Intent(Rlogin.this,Rhome.class));
        }*/

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputCode = Rcode.getText().toString();
                String inputName = Username.getText().toString();
                String inputPassword = Password.getText().toString();
                if (inputCode.isEmpty() || inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(Rlogin.this,"Please Enter All The Details",Toast.LENGTH_LONG).show();
                }else
                validate(Username.getText().toString(), Password.getText().toString());

            }
        });


    }


    public void validate(String username, String password){
        progressDialog.setMessage("Please wait");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Toast.makeText(Rlogin.this,"Login Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Rlogin.this,Rhome.class));
                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(Rlogin.this,"Login Failed", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }

}