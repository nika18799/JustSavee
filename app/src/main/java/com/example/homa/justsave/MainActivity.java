package com.example.homa.justsave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button films;
    Button book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        films = (Button) findViewById(R.id.buttonFilm);
        book = (Button) findViewById(R.id.buttonBook);

        films.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WatchedOrNot.class);
                startActivity(intent);
            }
        });



    }
}
