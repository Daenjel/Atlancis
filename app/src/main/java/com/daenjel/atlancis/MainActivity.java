package com.daenjel.atlancis;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //String color[] = {"RED","BLUE","YELLOW","GREEN"};

    Button submit;
    EditText numSocks;
    Spinner pickColor;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding views from xml
        numSocks = findViewById(R.id.socksNumber);
        pickColor = findViewById(R.id.color);
        submit = findViewById(R.id.btnSubmit);
        res = findViewById(R.id.results);

        //convert string input to integer
        //int Socks = Integer.parseInt(num);

        //button onclick
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

    }

    private void submit() {
        //getting user input
        String num = numSocks.getText().toString();

        //check is no user input
        if (num.isEmpty()){
            numSocks.setError("Enter Number");
            numSocks.requestFocus();
        }
        //checks if color is picked
        if (pickColor.getSelectedItem().equals("pick color")){
            res.setText(getString(R.string.pick));
            res.setTextColor(Color.RED);
        }
        //displaying results on textView if all conditions are met
        if (!num.isEmpty() && !pickColor.getSelectedItem().equals("pick color")) {
            res.setText(getString(R.string.display,num +" Color: "+pickColor.getSelectedItem().toString()));
            res.setTextColor(Color.GREEN);

            //reset input fields
            numSocks.setText(null);
            pickColor.setSelection(0);
        }

    }
}
