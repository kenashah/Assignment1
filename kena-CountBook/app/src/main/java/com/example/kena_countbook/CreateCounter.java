/*
 * CreateCounter activity
 *
 * Version 1.0
 *
 * October 1, 2017
 *
 * Copyright (c) 2017 Kena Shah, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the
 * Code of Student Behavior at the University of Alberta.
 * You can find a copy of the license of this project. Otherwise please contact contact@abc.ca.
 */

package com.example.kena_countbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Represents the CreateCounter activity.
 *
 * @author Kena Shah
 * @version 1.0
 * @since 1.0
 */
public class CreateCounter extends AppCompatActivity {
    private EditText name;
    private EditText current_value;
    private EditText initial_value;
    private EditText date;
    private EditText comment;

//    SharedPreferences sharedPreferences;
//    public static final String myPreferences = "myPrefs";

    private Counter[] counter_list;
    private ArrayAdapter<Counter> adapter;

    Button okButton;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_counter);

        defineValues();
        buttonHandler();
    }

    /**
     * Defines the initial values of all the variables.
     */
    public void defineValues() {
//        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        okButton = (Button) findViewById(R.id.okbutton);
        name = (EditText) findViewById(R.id.name);
        current_value = (EditText) findViewById(R.id.current_value);
        initial_value = (EditText) findViewById(R.id.initial_value);
        date = (EditText) findViewById(R.id.date);
        comment = (EditText) findViewById(R.id.comment);
    }

    /**
     * Handles the button input.
     */
    Integer index = 0;
    public void buttonHandler() {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Makes sure that the name and initial_value fields are not empty.
                 */
                if((name.getText().toString().length() == 0)
                        || (initial_value.getText().toString().length() == 0))  {
                    name.setError("Name is a required field.");
                    initial_value.setError("Initial value is a required field.");
                }
                String n = name.getText().toString();
                Integer c = Integer.parseInt(current_value.getText().toString());
                Integer i = Integer.parseInt(initial_value.getText().toString());
                String d = date.getText().toString();
                String com = comment.getText().toString();

//                SharedPreferences.Editor editor = sharedPreferences.edit();
//
//                editor.putString("name", n);
//                editor.putInt("current_value", c);
//                editor.putInt("initial_value", i);
//                editor.putString("date", d);
//                editor.putString("comment", com);
//                editor.apply();
                /**
                 * Parses the date into a given format, and checks to see if it is valid or not.
                 */
                DateFormat format = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
                Date actual_date = null;
                try {
                    actual_date = format.parse(d);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                counter_list[index] = new Counter(n, i, c, actual_date, com);
                counter_list[index].setName(n);
                counter_list[index].setCurrent_value(c);
                counter_list[index].setInitial_value(i);
                counter_list[index].setDate(actual_date);
                counter_list[index].setComment(com);
            }
        });


    }





}
