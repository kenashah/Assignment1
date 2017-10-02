package com.example.kena_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.kena_countbook.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void createCounterButtonClicked(View view) {
        Intent intent = new Intent(this, CreateCounter.class);
        startActivity(intent);
    }

    public void counterListButtonClicked(View view) {
        Intent intent = new Intent(this, CounterList.class);
        startActivity(intent);
    }
}
