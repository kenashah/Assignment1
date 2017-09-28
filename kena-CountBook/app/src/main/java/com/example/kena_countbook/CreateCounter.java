package com.example.kena_countbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class CreateCounter extends AppCompatActivity {
    String name_value;
    Integer current;
    Integer initial;
    Date date_value;
    String comment_value;

    EditText name;
    EditText current_value;
    EditText initial_value;
    EditText date;
    EditText comment;

    SharedPreferences nameSharedPreferences;
    SharedPreferences current_valueSharedPreferences;
    SharedPreferences initial_valueSharedPreferences;
    SharedPreferences dateSharedPreferences;
    SharedPreferences commentSharedPreferences;
    Button okButton;
    Button cancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_counter);

        defineValues();
        loadValues();
        buttonHandler();
    }

    public void defineValues() {
        nameSharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        current_valueSharedPreferences = getSharedPreferences("current_value", Context.MODE_PRIVATE);
        initial_valueSharedPreferences = getSharedPreferences("initial_value", Context.MODE_PRIVATE);
        dateSharedPreferences = getSharedPreferences("date", Context.MODE_PRIVATE);
        commentSharedPreferences = getSharedPreferences("comment", Context.MODE_PRIVATE);
        name = new EditText(this);
        current_value = new EditText(this);
        initial_value = new EditText(this);
        date = new EditText(this);
        comment = new EditText(this);
    }

    public void loadValues() {
        nameSharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        current_valueSharedPreferences = getSharedPreferences("current_value", Context.MODE_PRIVATE);
        initial_valueSharedPreferences = getSharedPreferences("initial_value", Context.MODE_PRIVATE);
        dateSharedPreferences = getSharedPreferences("date", Context.MODE_PRIVATE);
        commentSharedPreferences = getSharedPreferences("comment", Context.MODE_PRIVATE);
    }

    public void buttonHandler() {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().length() == 0) {
                    name.setError("Name is a required field.");
                } else if(initial_value.getText().toString().length() == 0) {
                    initial_value.setError("Initial value is a required field.");
                }
                commitToSharedPreferences();
            }
        });
    }

    public void commitToSharedPreferences() {
        nameSharedPreferences.edit().putString("name", name_value).apply();
        current_valueSharedPreferences.edit().putInt("current_value", current).apply();
        initial_valueSharedPreferences.edit().putInt("initial_value", initial).apply();

    }



}
