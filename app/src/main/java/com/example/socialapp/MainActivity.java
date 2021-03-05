package com.example.socialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.socialapp.ui.PostsFragment;
import com.example.socialapp.ui.ProfileFragment;
import com.example.socialapp.ui.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {




    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.profile: {
                    fragment = new ProfileFragment();
                    break;
                }
                case R.id.posts: {
                    fragment = new PostsFragment();
                    break;
                }
                case R.id.ssettings: {
                    fragment = new SettingsFragment();
                    break;
                }
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
            return true;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new PostsFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.posts);
    }
}