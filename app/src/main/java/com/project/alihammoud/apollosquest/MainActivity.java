package com.project.alihammoud.apollosquest;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private FrameLayout mMainFrame;
    private LandingFragment LandingFragment;
    private MainFragment MainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        mMainFrame = (FrameLayout) findViewById(R.id.frame);
        LandingFragment = new LandingFragment();
        MainFragment = new MainFragment();
        SetFragment(MainFragment,"main");


    }



    private void SetFragment(Fragment fragment, String tag){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, tag);
        fragmentTransaction.commit();

    }
}