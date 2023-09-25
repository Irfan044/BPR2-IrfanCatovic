package com.example.learningbcms.views;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.learningbcms.R;

public class BeginnerScreenFragment extends Fragment {

    private NavController navController;
    private Button continueButton;
    private MediaPlayer mediaPlayer;
    private ImageButton speakerButton1;
    private ImageButton speakerButton2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_beginner_screen, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        continueButton = rootView.findViewById(R.id.buttonContinue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_beginnerScreen_to_listFragment); //might be changed, linking somewhere else
            }
        });

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.dennissound);

        // Initialize ImageButtons by their IDs
        speakerButton1 = rootView.findViewById(R.id.speakerButton1);
        speakerButton2 = rootView.findViewById(R.id.speakerButton2);

        speakerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.dennissound);
            }
        });

        speakerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.kakosezovessound);
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void playSound(int soundResource) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(requireContext(), soundResource);
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}