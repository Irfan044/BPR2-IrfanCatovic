package com.example.learningbcms.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.example.learningbcms.R;

public class LessonMenuFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lesson_menu, container, false);

        CardView cardView1 = view.findViewById(R.id.cardView1);
        CardView cardView2 = view.findViewById(R.id.cardView2);
        CardView cardView3 = view.findViewById(R.id.cardView3);
        CardView cardView4 = view.findViewById(R.id.cardView4);
        CardView cardView5 = view.findViewById(R.id.cardView5);
        CardView cardView6 = view.findViewById(R.id.cardView6);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the first CardView
                // You can launch an activity or perform any action here
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the second CardView
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the third CardView
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the fourth CardView
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the fifth CardView
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the sixth CardView
            }
        });

        return view;
    }
}