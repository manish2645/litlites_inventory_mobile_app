package com.example.litlites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {

    private EditText etName,etEmail,etPhone,etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        getSupportActionBar().setTitle("Contact Distributer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (EditText) findViewById(R.id.Name);
        etEmail = (EditText) findViewById(R.id.Email);
        etPhone = (EditText) findViewById(R.id.Phone);
        etMessage = (EditText) findViewById(R.id.Message);
        btnSend = (Button) findViewById(R.id.Send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ContactUs.this,
                        Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED){
                    sendMessage();
                    //startActivity(new Intent(Contact.this,Rhome.class));

                }else{
                    ActivityCompat.requestPermissions(ContactUs.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });
    }
    private void sendMessage(){
        String sName = etName.getText().toString().trim();
        String sEmail = etEmail.getText().toString().trim();
        String sPhone = etPhone.getText().toString().trim();
        String sMessage = etMessage.getText().toString().trim();
        if(!sPhone.equals("")&& !sMessage.equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(sPhone,null, sMessage,null,null);

            Toast.makeText(getApplicationContext(),"Message sent successfully",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Enter the Correct phone number",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            sendMessage();

        }else
        {
            Toast.makeText(getApplicationContext(),"Permission Denied!",Toast.LENGTH_LONG).show();
        }
    }
}
