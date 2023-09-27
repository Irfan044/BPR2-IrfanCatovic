package com.example.learningbcms.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.learningbcms.R;
import com.example.learningbcms.viewmodel.AuthViewModel;

public class SettingsFragment extends Fragment {

    private AuthViewModel authViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        Button signOutButton = rootView.findViewById(R.id.signOutButton);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authViewModel.signOut();
            }
        });

        return rootView;
    }
}