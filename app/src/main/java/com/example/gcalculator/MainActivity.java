package com.example.gcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private TextView textView;
    private EditText editText;
    private final String editTextKey = "editTextKey";
    private ArrayList<String> inputArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputArr = new ArrayList<String>();
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextInput);

        buttonReset();
    }

    private void buttonReset() {
        Button btn_reset = findViewById(R.id.button_reset);
        btn_reset.setOnClickListener(v -> editText.setText(""));
    }

    public void buttonOnClick(View v) {
        Button b = (Button)v;
        editText.setText(getResources().getString(R.string.result_template, editText.getText(), b.getText().toString()));
        inputArr.add(b.getText().toString());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(editTextKey, (Serializable) editText);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText = (EditText) savedInstanceState.getSerializable(editTextKey);
    }
}