package com.example.learningbcms.views;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.learningbcms.R;

public class TransportFragment extends Fragment {

    private NavController navController;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transport, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // Initialize MediaPlayer
        mediaPlayer = new MediaPlayer();

        // Set click listeners for the LinearLayouts
        setLinearLayoutClickListeners(rootView);

        // Set click listener for the continue button
        Button continueButton = rootView.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_transportFragment_to_listFragment);
            }
        });

        return rootView;
    }

    private void setLinearLayoutClickListeners(View rootView) {
        setLinearLayoutClickListener(rootView, R.id.pedestrianLayout, R.raw.pedestrian_sound);
        setLinearLayoutClickListener(rootView, R.id.zebracrossingLayout, R.raw.zebra_crossing);
        setLinearLayoutClickListener(rootView, R.id.bicycleLayout, R.raw.bicycle_sound);
        setLinearLayoutClickListener(rootView, R.id.scooterLayout, R.raw.scooter_sound);
        setLinearLayoutClickListener(rootView, R.id.motorcycleLayout, R.raw.motorcycle_sound);
        setLinearLayoutClickListener(rootView, R.id.carLayout, R.raw.car_sound);
        setLinearLayoutClickListener(rootView, R.id.truckLayout, R.raw.truck_sound);
        setLinearLayoutClickListener(rootView, R.id.drivinglicenseLayout, R.raw.drivinglicense_sound);
        setLinearLayoutClickListener(rootView, R.id.busLayout, R.raw.bus_sound);
        setLinearLayoutClickListener(rootView, R.id.busstationLayout, R.raw.busstation_sound);
        setLinearLayoutClickListener(rootView, R.id.motorwayLayout, R.raw.motorway_sound);
        setLinearLayoutClickListener(rootView, R.id.trainLayout, R.raw.train_sound);
        setLinearLayoutClickListener(rootView, R.id.trainstationLayout, R.raw.trainstation_sound);
        setLinearLayoutClickListener(rootView, R.id.tramwayLayout, R.raw.tramway_sound);
        setLinearLayoutClickListener(rootView, R.id.airplaneLayout, R.raw.airplane_sound);
        setLinearLayoutClickListener(rootView, R.id.airportLayout, R.raw.airport_sound);
    }

    private void setLinearLayoutClickListener(View rootView, int layoutId, final int soundResourceId) {
        LinearLayout linearLayout = rootView.findViewById(layoutId);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Play the corresponding sound when the LinearLayout is clicked
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
                mediaPlayer = MediaPlayer.create(getActivity(), soundResourceId);
                mediaPlayer.start();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}