package com.project.alihammoud.apollosquest;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LevelSelectionsFragment extends Fragment implements View.OnClickListener {

private CardView levelTwo, levelone;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_selection, container, false);

        levelTwo = view.findViewById(R.id.card_level_two);
        levelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LevelTwo.class);
                startActivity(intent);
            }
        });

        levelone = view.findViewById(R.id.card_level_one);
        levelone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LevelOne.class);
                startActivity(intent);
            }
        });
        return view;
    }


    @Override
    public void onClick(View v) {

    }
}