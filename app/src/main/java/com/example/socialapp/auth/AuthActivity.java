package com.example.socialapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.socialapp.MainActivity;
import com.example.socialapp.R;
import com.example.socialapp.databinding.ActivityAuthBinding;
import com.google.android.gms.common.SignInButton;

public class AuthActivity extends AppCompatActivity {

    Button anonymous;
    SignInButton googleAuth;
    ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        anonymous = binding.anonymous;
        anonymous.setOnClickListener((v) -> {
            SharedPreferences sh = getSharedPreferences(getResources().getString(R.string.app_name), 0);
            SharedPreferences.Editor ed = sh.edit();
            ed.putString("auth_type", "anon");
            ed.putBoolean("auth", true);
            ed.apply();
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
            finish();
        });

        googleAuth = binding.authGoogle;
        googleAuth.setOnClickListener((v) -> {
            /*
            TODO: create the google authorization
             */
            SharedPreferences sh = getSharedPreferences(getResources().getString(R.string.app_name), 0);
            SharedPreferences.Editor ed = sh.edit();
            ed.putString("auth_type", "google");
            ed.putBoolean("auth", true);
            ed.apply();
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
            finish();
        });
    }
}