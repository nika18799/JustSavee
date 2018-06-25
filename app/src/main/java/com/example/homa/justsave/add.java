package com.example.homa.justsave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class add extends AppCompatActivity {

        EditText editText;
        Button add;
        Button save;
        String temp;
    ArrayList<String> arrayAdd = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        add = (Button) findViewById(R.id.buttonAdd);
        save = (Button) findViewById(R.id.buttonSave);
        editText = (EditText) findViewById(R.id.EditTextAdd);
       // Intent intent = getIntent();
       // arrayAdd  = intent.getStringArrayListExtra("filmsArray");



        add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                temp = editText.getText().toString();
                arrayAdd.add("\n");
                arrayAdd.add(temp);

            }
        });

        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(add.this, Films.class);
                intent.putStringArrayListExtra("filmsArrayAdd",arrayAdd);
                startActivity(intent);
            }
        });

    }
}
