package com.dev.passwordgenerator.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dev.passwordgenerator.R;
import com.dev.passwordgenerator.adapter.PageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScreenCall();
    }

    private void initiateVariable()
    {
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
    }

    private void ScreenCall()
    {
        initiateVariable();

        tabLayout.addTab(tabLayout.newTab().setText("Password"));
        tabLayout.addTab(tabLayout.newTab().setText("PIN"));

        PageAdapter myPagerAdapter=new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.VISIBLE);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
