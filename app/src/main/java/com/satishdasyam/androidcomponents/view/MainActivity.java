package com.satishdasyam.androidcomponents.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.satishdasyam.androidcomponents.R;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());
        if (savedInstanceState == null) {
            UserFragment userFragment = new UserFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, userFragment,
                    UserFragment.class.getSimpleName()).commit();
        }
    }
}
