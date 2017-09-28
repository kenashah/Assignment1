package com.example.kena_countbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateCounter extends AppCompatActivity {
    String name_value;
    Integer current;
    Integer initial;
    Date date_value;
    String comment_value;

    ArrayList<Counter> counter = new ArrayList<Counter>();

    EditText name;
    EditText current_value;
    EditText initial_value;
    EditText date;
    EditText comment;

    SharedPreferences sharedPreferences;
    public static final String myPreferences = "myPrefs";

    Button okButton;
    Button cancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_counter);

        defineValues();
        buttonHandler(); // invoking the button handler causes app to crash
    }

    public void defineValues() {
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        okButton = (Button) findViewById(R.id.okbutton);
        cancelButton = (Button) findViewById(R.id.cancelbutton);
        name = (EditText) findViewById(R.id.name);
        current_value = (EditText) findViewById(R.id.current_value);
        initial_value = (EditText) findViewById(R.id.initial_value);
        date = (EditText) findViewById(R.id.date);
        comment = (EditText) findViewById(R.id.comment);
    }

    public void buttonHandler() {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((name.getText().toString().length() == 0)
                        || (initial_value.getText().toString().length() == 0))  {
                    name.setError("Name is a required field.");
                    initial_value.setError("Initial value is a required field.");
                }
                String n = name.getText().toString();
                Integer c = current_value.getText();
                Integer i = initial_value.getText().toString();
                String d = date.getText().toString();
                String com = comment.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", n);
                editor.putInt("current_value", c);
                editor.putInt("initial_value", i);
                editor.putString("date", d);
                editor.putString("comment", com);
                editor.apply();

                Date actual_date = new SimpleDateFormat("") // finish this
                Counter new_counter = new Counter(n, c, i, d, com); // fix this 
                counter.add()
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // implement a way to go back to home screen when CANCEL button is pressed
            }
        });
    }





}
