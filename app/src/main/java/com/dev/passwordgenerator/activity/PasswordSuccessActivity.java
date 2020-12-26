package com.dev.passwordgenerator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.passwordgenerator.R;

import org.apache.commons.lang3.RandomStringUtils;

import es.dmoral.toasty.Toasty;

public class PasswordSuccessActivity extends AppCompatActivity {

    private int passLength;
    TextView tvPassword;
    private String setPass;
    private String mPassword;
    Button btnRegeneratePassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_success);

        tvPassword = findViewById(R.id.tv_password);
        btnRegeneratePassword = findViewById(R.id.btn_regenerate_password);
        mPassword = getIntent().getStringExtra("mPassword");
        passLength = getIntent().getIntExtra("mPassLength", 2);

        generatePassword();
        regeneratePassword();
    }

    private void regeneratePassword()
    {
        btnRegeneratePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePassword();
            }
        });
    }


    private void copyToBoard() {
        tvPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager myClipboard;
                ClipData myClip;

                myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

                myClip = ClipData.newPlainText("text", setPass);
                myClipboard.setPrimaryClip(myClip);
                Toasty.success(getApplicationContext(), "Copied To Clip Board", Toast.LENGTH_SHORT, true).show();
            }
        });
    }

    private void generatePassword() {
        setPass = RandomStringUtils.random(passLength, mPassword);
        tvPassword.setText(setPass);
        copyToBoard();
    }
}