package com.dev.passwordgenerator.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dev.passwordgenerator.fragment.PasswordFragment;
import com.dev.passwordgenerator.fragment.PinFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private String s;

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                PasswordFragment passwordFragment=new PasswordFragment(s);
                return passwordFragment;
            case 1:
                PinFragment pinFragment=new PinFragment(s);
                return pinFragment;
//            case 2:
//                PasswordFragment passwordFragment=new PasswordFragment(s);
//                return passwordFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}