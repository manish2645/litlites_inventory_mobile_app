package com.example.litlites;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class AboutUs extends AppCompatActivity {
    //private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*videoView = findViewById(R.id.video_View);
        /*videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.hd0506);

        MediaController mediaController =new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);*/


    }
}