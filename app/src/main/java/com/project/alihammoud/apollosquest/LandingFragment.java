package com.project.alihammoud.apollosquest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class LandingFragment extends Fragment implements View.OnClickListener {
    private ImageButton play, store, chat;
    private ChatFragment ChatFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_landing, container, false);

        play = view.findViewById(R.id.play);
        store = view.findViewById(R.id.store);
        chat = view.findViewById(R.id.chat);




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new LevelSelectionsFragment()).addToBackStack("play-levels");
                ft.commit();
            }
        });




        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new StoreFragment()).addToBackStack("store");
                ft.commit();
            }
        });


       /* Bundle bundle = this.getArguments();
        String name = bundle.getString("Name");*/

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



               /* ChatFragment= new ChatFragment ();
                Bundle bundle = new Bundle();
                bundle.putString("Name",name);
                ChatFragment.setArguments(bundle);*/

                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new ChatFragment()).addToBackStack("chat");
                ft.commit();
            }
        });


        return view;
    }


    @Override
    public void onClick(View v) {

    }
}