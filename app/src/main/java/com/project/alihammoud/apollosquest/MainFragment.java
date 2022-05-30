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
import android.widget.EditText;
import android.widget.Toast;

public class MainFragment extends Fragment implements View.OnClickListener {
    private Button play;
    private EditText edtFirstName;
    private LandingFragment LandingFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        play = view.findViewById(R.id.play);
        edtFirstName = view.findViewById(R.id.edtFirstName);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtFirstName.getText().toString();

             /*   LandingFragment= new LandingFragment ();
                Bundle bundle = new Bundle();
                bundle.putString("Name",name);
                LandingFragment.setArguments(bundle);*/

                //Toast.makeText(getActivity(),name,Toast.LENGTH_LONG).show();
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new LandingFragment()).commit();


            }
        });






        return view;
    }


    @Override
    public void onClick(View v) {

    }
}