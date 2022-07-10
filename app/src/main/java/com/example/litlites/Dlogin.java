package com.example.litlites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dlogin extends AppCompatActivity {

    private EditText dcode;
    private EditText dusername;
    private EditText dpassword;
    private Button dlogin;
    private ProgressDialog progressDialog;

    boolean isValid = false;

    Credential credential = new Credential("878763","Arbind32","Manish");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlogin);

        getSupportActionBar().setTitle("Distributer Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dcode = (EditText) findViewById(R.id.Code);
        dusername = (EditText) findViewById(R.id.Username);
        dpassword = (EditText) findViewById(R.id.Password);
        dlogin = (Button) findViewById(R.id.loginD);
        progressDialog = new ProgressDialog(this);

        credential.setCode("907719");
        credential.setUsername("ArbindEnterprise");
        credential.setPassword("Manish2645");

        dlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait");
                progressDialog.show();
                String inputCode = dcode.getText().toString();
                String inputName = dusername.getText().toString();
                String inputPassword = dpassword.getText().toString();

                if(inputCode.isEmpty() || inputName.isEmpty() || inputPassword.isEmpty())
                {
                    DisplayToast1();
                }else{
                    isValid = validate(inputCode,inputName,inputPassword);
                    if(!isValid)
                    {
                        DisplayToast();

                    }else{
                        DisplayToast2();
                        Intent intent = new Intent(Dlogin.this, Dhome.class);
                        startActivity(intent);
                    }

                }

            }
        });
    }

    private void openLoginActivity() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void DisplayToast(){
        progressDialog.dismiss();
        Toast.makeText(this, "Enter the corect details!",Toast.LENGTH_SHORT).show();
    }
    public void DisplayToast1(){
        progressDialog.dismiss();
        Toast.makeText( this,"Please Enter All The Details",Toast.LENGTH_SHORT).show();
    }
    public void DisplayToast2(){
        progressDialog.dismiss();
        Toast.makeText(this, "Login Successful",Toast.LENGTH_SHORT).show();
    }
    private boolean validate(String number, String user, String pass){
        if(number.equals(credential.getCode()) && user.equals(credential.getEmail()) && pass.equals(credential.getPassword())){
            return true;
        }
        return false;
    }

}
