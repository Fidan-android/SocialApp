package com.example.socialapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.socialapp.MainActivity;
import com.example.socialapp.R;

public class AuthActivity extends AppCompatActivity {

    Button anonymous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        anonymous = findViewById(R.id.anonymous);
        anonymous.setOnClickListener((v) -> {
            SharedPreferences sh = getSharedPreferences(getResources().getString(R.string.app_name), 0);
            SharedPreferences.Editor ed = sh.edit();
            ed.putString("auth_type", "anon");
            ed.putBoolean("auth", true);
            ed.apply();
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
            finish();
        });
    }
}