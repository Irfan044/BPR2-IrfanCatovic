package com.example.learningbcms.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.learningbcms.R;
import com.example.learningbcms.viewmodel.AuthViewModel;

public class SplashFragment extends Fragment {

    private NavController navController;
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String BUTTON_CLICKED_KEY = "start_button_clicked";
    private AuthViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(requireActivity().getApplication())).get(AuthViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavHostFragment navHostFragment = (NavHostFragment) requireActivity()
                .getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        view.findViewById(R.id.startButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModel.getCurrentUser() != null) {
                    navController.navigate(R.id.action_splashFragment_to_beginnerScreen); //change back to listFragment
                } else {
                    navController.navigate(R.id.action_splashFragment_to_signInFragment);
                }

                saveStartButtonClickedStatus(true);
            }
        });

        if (!isStartButtonClicked()) {
            navController.navigate(R.id.action_splashFragment_to_listFragment);
        }

        // Add a click listener for the Sign Out button
        /*view.findViewById(R.id.signOutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut(); // Call the signOut method to implement Sign Out functionality
            }
        });

        if (!isStartButtonClicked()) {
            navController.navigate(R.id.action_splashFragment_to_listFragment);
        }*/
    }

    private void saveStartButtonClickedStatus(boolean isClicked) {
        SharedPreferences.Editor editor = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(BUTTON_CLICKED_KEY, isClicked);
        editor.apply();
    }

    private boolean isStartButtonClicked() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(BUTTON_CLICKED_KEY, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    // For testing purposes only
    /*private void signOut() {
        viewModel.signOut();
        saveStartButtonClickedStatus(false);
        navController.navigate(R.id.action_splashFragment_to_signInFragment);
    }*/
}
