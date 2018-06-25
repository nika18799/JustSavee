package com.example.homa.justsave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WatchedOrNot extends AppCompatActivity {

    Button watched;
    Button notWatched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watched_or_not);

        watched = (Button) findViewById(R.id.buttonWatched);
        notWatched = (Button) findViewById(R.id.buttonNotWatched);

        watched.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchedOrNot.this, Films.class);
                startActivity(intent);
            }
        });


        //доделать
        notWatched.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchedOrNot.this, WatchedOrNot.class);
                startActivity(intent);
            }
        });

    }
}
