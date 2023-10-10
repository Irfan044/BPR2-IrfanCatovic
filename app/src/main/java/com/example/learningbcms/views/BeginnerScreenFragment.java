package com.example.learningbcms.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.learningbcms.R;

public class BeginnerScreenFragment extends Fragment {

    private NavController navController;
    private Button quizButton;
    private Button newLessonButton;
    private Button buttonWatchVideo;
    private MediaPlayer mediaPlayer;
    private Button buttonSpeaker1;
    private Button buttonSpeaker2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_beginner_screen, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        quizButton = rootView.findViewById(R.id.buttonQuiz);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_beginnerScreen_to_listFragment);
            }
        });

        newLessonButton = rootView.findViewById(R.id.buttonNewLesson);
        newLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_beginnerScreen_to_transportFragment);
            }
        });

        buttonWatchVideo = rootView.findViewById(R.id.buttonWatchVideo);
        buttonWatchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeVideo();
            }
        });

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.dennissound);

        // Initialize ImageButtons by their IDs
        buttonSpeaker1 = rootView.findViewById(R.id.buttonSpeaker1);
        buttonSpeaker2 = rootView.findViewById(R.id.buttonSpeaker2);

        buttonSpeaker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.dennissound);
            }
        });

        buttonSpeaker2.setOnClickListener(new View.OnClickListener() {
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

    private void openYouTubeVideo() {
        String videoUrl = "https://www.youtube.com/watch?v=y99P56AZvLo&ab_channel=Slavyansk";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
        intent.setPackage("com.google.android.youtube");

        if (intent.resolveActivity(requireContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            intent.setPackage(null);
            startActivity(intent);
        }
    }
}