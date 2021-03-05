package com.example.socialapp.ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialapp.R;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences preferences = getActivity().getSharedPreferences(getResources().getString(R.string.app_name), 0);
        String auth_type = preferences.getString("auth_type", "");
        switch (auth_type){
            case "anon": {
                break;
            }
            case "google": {
                break;
            }
        }
        return view;
    }

    private void anonymousAccount(){

    }

}