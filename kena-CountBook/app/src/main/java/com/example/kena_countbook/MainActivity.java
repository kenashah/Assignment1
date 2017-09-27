package com.example.kena_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.kena_countbook.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void NewCounterButtonClicked(View view) {
        // Do something in response to button
        // display the Counter fields, which will take the inputs to create a new counter
        Intent intent = new Intent(this, CreateCounter.class);
        startActivity(intent);
    }
}
