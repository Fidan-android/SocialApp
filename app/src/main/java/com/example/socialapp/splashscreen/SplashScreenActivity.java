package com.example.socialapp.splashscreen;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.socialapp.MainActivity;
import com.example.socialapp.R;
import com.example.socialapp.auth.AuthActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            SharedPreferences sh = getSharedPreferences(getResources().getString(R.string.app_name), 0);
            if (sh.getBoolean("auth", false)){
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            } else {
                startActivity(new Intent(SplashScreenActivity.this, AuthActivity.class));
                finish();
            }
        }, 2000);
    }
}