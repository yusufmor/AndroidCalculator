package com.example.javacalculator;

import android.view.View;
import android.widget.EditText;

public class NumberOnClickListener implements View.OnClickListener {
    private final int number;
    private EditText editText

    public NumberOnClickListener(int number_ , EditText editText_) {
        number = number_;
        editText = editText_;
    }

    @Override
    public void onClick(View v) {
        String mathText = editText.getText().toString();

        if (mathText.endsWith("0")) {
            mathText = mathText.substring(0 , mathText.length() - 2) + number;
        } else {
            mathText += number;
        }
        editText.setText(mathText);
    }
}