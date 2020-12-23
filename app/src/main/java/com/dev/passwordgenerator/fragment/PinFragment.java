package com.dev.passwordgenerator.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dev.passwordgenerator.activity.PinSuccessActivity;
import com.dev.passwordgenerator.R;
import com.google.android.material.textfield.TextInputLayout;

import es.dmoral.toasty.Toasty;


public class PinFragment extends Fragment {


    public PinFragment(String s) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pin, container, false);

        Button BtnSubmit = view.findViewById(R.id.btn_submit);
        TextInputLayout textInputLayout = view.findViewById(R.id.til_pin);
        Editable pinLength = textInputLayout.getEditText().getText();


        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pin = String.valueOf(pinLength);


                if (TextUtils.isEmpty(pin)) {
                    Toasty.error(getActivity(), "Enter Digit Between 1 to 9", Toast.LENGTH_SHORT, true).show();
                } else {
                    int finalPin = Integer.parseInt(pin);
                    if (finalPin == 0) {
                        Toasty.error(getActivity(), "Enter Digit Between 1 to 9", Toast.LENGTH_SHORT, true).show();
                    } else {
                        Intent intent = new Intent(getActivity(), PinSuccessActivity.class);
                        intent.putExtra("PIN", finalPin);
                        startActivity(intent);
                    }
                }
            }
        });
        return view;
    }


}