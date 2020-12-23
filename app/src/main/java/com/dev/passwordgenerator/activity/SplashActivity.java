package com.dev.passwordgenerator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.dev.passwordgenerator.R;

public class SplashActivity extends AppCompatActivity {


    private void audioPlay()
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wow);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initiateHandler();
        audioPlay();
    }


    private void initiateHandler() {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2500);

    }




}