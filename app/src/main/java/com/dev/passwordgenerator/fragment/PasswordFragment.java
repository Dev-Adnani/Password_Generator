package com.dev.passwordgenerator.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.passwordgenerator.R;
import com.dev.passwordgenerator.activity.PasswordSuccessActivity;
import com.dev.passwordgenerator.activity.PinSuccessActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;

import org.apache.commons.lang3.RandomStringUtils;

import es.dmoral.toasty.Toasty;


public class PasswordFragment extends Fragment {


    public PasswordFragment(String s) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password, container, false);


        Button btn_Pass = view.findViewById(R.id.btn_pass);
        TextInputLayout textInputLayout = view.findViewById(R.id.til_password);
        Editable passLength = textInputLayout.getEditText().getText();


        btn_Pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = String.valueOf(passLength);

                if (TextUtils.isEmpty(pass)) {
                    Toasty.error(getActivity(), "Enter Digit Between 1 to 25", Toast.LENGTH_SHORT, true).show();
                }
                else {
                    int finalPassLength = Integer.parseInt(pass);

                    if (finalPassLength == 0 ) {
                        Toasty.error(getActivity(), "Enter Digit Between 1 to 25", Toast.LENGTH_SHORT, true).show();
                    }
                    else if( finalPassLength >25)
                    {
                        Toasty.error(getActivity(), "Enter Digit Between 1 to 25", Toast.LENGTH_SHORT, true).show();
                    }
                    else {
                        Intent intent = new Intent(getActivity(), PasswordSuccessActivity.class);
                        intent.putExtra("PWDs", finalPassLength);
                        startActivity(intent);
                    }
                }
            }
        });

        return view;
    }


}