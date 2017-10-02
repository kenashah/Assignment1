/*
 * CounterList
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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
 * Supposed to implement the different activity which shows the list of counters created.
 */
public class CounterList extends AppCompatActivity {
    private ListView oldCounterList;
    private String name;
    private Integer currentValue;
    private Integer initialValue;
    private Date date;
    private String comment;

    private ArrayList<Counter> counterList;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_list);
    }

    public void displayCounters() {
    }

}
