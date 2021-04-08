package com.example.socialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.socialapp.adapters.PostsAdapter;
import com.example.socialapp.databinding.ActivityMainBinding;
import com.google.android.gms.common.SignInButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = binding.bottomNav;
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.profile: {
                    setLayoutBottomNav(View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                    toolbar.setTitle("Профиль");
                    break;
                }
                case R.id.posts: {
                    setLayoutBottomNav(View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                    toolbar.setTitle("Посты");
                    //set adapter for recycler view
                    binding.recyclerPosts.setAdapter(new PostsAdapter(this));
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    binding.recyclerPosts.setLayoutManager(layoutManager);
                    //set adapter for recycler view
                    break;
                }
                case R.id.settings: {
                    setLayoutBottomNav(View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
                    toolbar.setTitle("Настройки");
                    //set visibility for layouts
                    LinearLayout block_info = binding.blockInfo;
                    LinearLayout no_auth_google = binding.noAuthGoogle;

                    SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.app_name), 0);
                    String auth_type = sharedPreferences.getString("auth_type", "");
                    switch (auth_type){
                        case "anon":{
                            no_auth_google.setVisibility(View.VISIBLE);
                            block_info.setVisibility(View.INVISIBLE);
                            break;
                        }
                        case "google":{
                            block_info.setVisibility(View.VISIBLE);
                            no_auth_google.setVisibility(View.INVISIBLE);
                            break;
                        }
                        default:{
                            break;
                        }
                    }

                    SignInButton signInButton = binding.googleSign;
                    signInButton.setOnClickListener((v) -> {
                        Snackbar.make(v, "Заглушка", Snackbar.LENGTH_SHORT).show();
                    });
                    //set visibility for layouts
                    break;
                }
            }
            return true;
        });
        bottomNavigationView.setSelectedItemId(R.id.posts);

        binding.addPost.setOnClickListener(v -> {

        });
    }

    private void setLayoutBottomNav(int profile, int posts, int settings){
        binding.profile.setVisibility(profile);
        binding.posts.setVisibility(posts);
        binding.settings.setVisibility(settings);
    }
}