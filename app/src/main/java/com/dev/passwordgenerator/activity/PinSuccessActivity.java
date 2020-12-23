package com.dev.passwordgenerator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.passwordgenerator.R;

import java.util.Random;

import es.dmoral.toasty.Toasty;

public class PinSuccessActivity extends AppCompatActivity {

    private int pin;
    TextView tvPass;
    private int fPin = 0;
    private Button btnRegenerate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinsuccess);

        btnRegenerate = findViewById(R.id.btn_regenerate_pin);

        pin = getIntent().getIntExtra("PIN", 3);
        initialiseData();

       newPin();
    }

    private void newPin()
    {
        btnRegenerate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                pin = getIntent().getIntExtra("PIN", 3);
                initialiseData();
            }
        });
    }

    private void copyPin() {
        tvPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager myClipboard;
                ClipData myClip;

                myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

                String clipCopy = String.valueOf(fPin);
                myClip = ClipData.newPlainText("text", clipCopy);
                myClipboard.setPrimaryClip(myClip);
                Toasty.success(getApplicationContext(), "Copied To Clip Board", Toast.LENGTH_SHORT, true).show();
            }
        });
    }

    private void pinGenerator() {
        tvPass = findViewById(R.id.tv_pass);
        int min = 0;
        int max = 0;
        Random rand = new Random();

        if (pin == 1) {
            min = 1;
            max = 9;
            fPin = rand.nextInt(max - min + 1) + min;
            Log.e("Af Pin", String.valueOf(fPin));
        } else if (pin == 2) {
            min = 10;
            max = 99;
            fPin = rand.nextInt(max - min + 1) + min;
        } else if (pin == 3) {
            min = 100;
            max = 999;
            fPin = rand.nextInt(max - min + 1) + min;
        } else if (pin == 4) {
            min = 1000;
            max = 9999;
            fPin = rand.nextInt(max - min + 1) + min;
        } else if (pin == 5) {
            min = 10000;
            max = 99999;
            fPin = rand.nextInt(max - min + 1) + min;
        } else if (pin == 6) {
            min = 100000;
            max = 999999;
            fPin = rand.nextInt(max - min + 1) + min;
        } else if (pin == 7) {
            min = 1000000;
            max = 9999999;
            fPin = rand.nextInt(max - min + 1) + min;
        } else if (pin == 8) {
            min = 10000000;
            max = 99999999;
            fPin = rand.nextInt(max - min + 1) + min;
        } else if (pin == 9) {
            min = 100000000;
            max = 999999999;
            fPin = rand.nextInt(max - min + 1) + min;
        }

        tvPass.setText(String.valueOf(fPin));
        copyPin();
    }

    private void initialiseData() {
        TextView tvPass = findViewById(R.id.tv_pass);
        TextView tvPassTitle = findViewById(R.id.tv_pass_title);
        tvPassTitle.setText("Your Pin Is");
        TextView tvCopy = findViewById(R.id.tv_copy);
        tvCopy.setText("Click On Your Pin To Copy It");


        pinGenerator();
    }


}