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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import static com.example.kena_countbook.CreateCounter.*;

public class CounterList extends AppCompatActivity {
    private ListView oldCountersList;
    private Counter newCounter;
    private String name;
    private Integer current_value;
    private Integer initial_value;
    private Date date;
    private String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_list);

        oldCountersList = (ListView) findViewById(R.id.listview);
    }

    public void displayCounters() {
        name = newCounter.getName();
        current_value = newCounter.getCurrent_value();
        initial_value = newCounter.getInitial_value();
        date = newCounter.getDate();
        comment = newCounter.getComment();
        
    }


}
