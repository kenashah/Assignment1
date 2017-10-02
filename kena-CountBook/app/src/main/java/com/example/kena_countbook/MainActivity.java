/*
 * MainActivity
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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Represents the MainActivity.
 *
 * @author Kena Shah
 * @version 1.0
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the Create Counter button is clicked.
     *
     * @param view
     */
    public void createCounterButtonClicked(View view) {
        Intent intent = new Intent(this, CreateCounter.class);
        startActivity(intent);
    }

    /**
     * Called when the Counter List button is clicked.
     *
     * @param view
     */
    public void counterListButtonClicked(View view) {
        Intent intent = new Intent(this, CounterList.class);
        startActivity(intent);
    }
}
