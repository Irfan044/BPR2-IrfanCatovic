package com.example.learningbcms.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.learningbcms.R;

public class LessonMenuFragment extends Fragment {

    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lesson_menu, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        CardView cardView1 = view.findViewById(R.id.cardView1);
        CardView cardView2 = view.findViewById(R.id.cardView2);
        CardView cardView3 = view.findViewById(R.id.cardView3);
        CardView cardView4 = view.findViewById(R.id.cardView4);
        CardView cardView5 = view.findViewById(R.id.cardView5);
        CardView cardView6 = view.findViewById(R.id.cardView6);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_lessonMenuFragment_to_beginnerScreen);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "NOT IMPLEMENTED", Toast.LENGTH_SHORT).show();
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_lessonMenuFragment_to_transportFragment);
            }
        });

        return view;
    }
}