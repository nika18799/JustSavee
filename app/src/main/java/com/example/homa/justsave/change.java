package com.example.homa.justsave;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class change extends AppCompatActivity {
    Button changeButton;
    Button deleteButton;
    EditText changeEditText;
    TextView changeTextView;
int positional = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        changeButton = (Button) findViewById(R.id.buttonChange);
        deleteButton = (Button) findViewById(R.id.buttonDelete);
        changeEditText = (EditText) findViewById(R.id.EditTextChange);
        changeTextView = (TextView) findViewById(R.id.textViewChange);

        Intent intent = getIntent();

 String s = intent.getStringExtra("position");
        changeTextView.setText(s+" - ");
     //   positional = Integer.parseInt(s);

      /*  changeButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
              changeTextView.setText(position);
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });*/

        //Intent intent = getIntent();
       // position  = intent.getIntExtra("position");
    }
}
