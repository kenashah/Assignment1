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
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
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

    private static final String FILENAME = "file.sav";
    private EditText name;
    private EditText currentValue;
    private EditText initialValue;
    private EditText date;
    private EditText comment;
    private ListView oldCounterList;

    private ArrayList<Counter> counterList;
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
        okButton = (Button) findViewById(R.id.okbutton);
        name = (EditText) findViewById(R.id.name);
        currentValue = (EditText) findViewById(R.id.currentValue);
        initialValue = (EditText) findViewById(R.id.initialValue);
        date = (EditText) findViewById(R.id.date);
        comment = (EditText) findViewById(R.id.comment);
        oldCounterList = (ListView) findViewById(R.id.oldCounterList);
    }

    /**
     * Handles the button input.
     */

    public void buttonHandler() {
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /**
                 * Makes sure that the name and initialValue fields are not empty.
                 */
                if((name.getText().toString().length() == 0)
                        || (initialValue.getText().toString().length() == 0))  {
                    name.setError("Name is a required field.");
                    initialValue.setError("Initial value is a required field.");
                }
                String n = name.getText().toString();
                Integer c = Integer.parseInt(currentValue.getText().toString());
                Integer i = Integer.parseInt(initialValue.getText().toString());
                String d = date.getText().toString();
                String com = comment.getText().toString();

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

                counterList.add(new Counter(n, i, c, actual_date, com));
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });


    }


    /**
     * Called when the activity is started.
     */
    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Counter>(this, R.layout.list_item, counterList);
        oldCounterList.setAdapter(adapter);
    }

    /**
     * Called to load input from file.
     */
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Counter>>() {}.getType();
            counterList = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            counterList = new ArrayList<Counter>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Called to save input to file.
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(counterList, writer);
            writer.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
