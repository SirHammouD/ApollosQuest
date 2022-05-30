package com.project.alihammoud.apollosquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;


public class LevelOne extends AppCompatActivity {

    private ImageButton carrot, apple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        carrot = findViewById(R.id.carrot);
        apple = findViewById(R.id.apple);


        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Great Work!", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });


        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Try Again", Toast.LENGTH_LONG).show();
            }
        });
    }
}