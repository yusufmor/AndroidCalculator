package com.example.javacalculator;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOnClickListener implements View.OnClickListener {
    private final String number;
    private final TextView editText;
    private final List<String> semboles = Arrays.asList("+" , "-" ,"%" , "÷" ,"(" , ")" , "×");

    public NumberOnClickListener(String number_ , TextView editText_) {
        number = number_;
        editText = editText_;
    }

    @Override
    public void onClick(View v) {

        if (editText.getText().toString() == null) {
            editText.setText("");
        }

        Pattern pattern = Pattern.compile("([-+%÷×\\(\\)]0||^0$)$" ,  Pattern.UNIX_LINES);
        String mathText = editText.getText().toString();
        Matcher m = pattern.matcher(mathText);



        System.out.println(mathText);
        boolean value  = m.find();
        System.out.println(mathText.endsWith(")"));
        value = mathText.endsWith(")");

        if (m.find() && mathText.length() > 0) {
            String format = mathText.substring(0, mathText.length() - 1) + String.valueOf(number);
            editText.setText(format);

        } else if (m.find()) {
            editText.setText(mathText + String.valueOf(number));

        } else if (mathText.endsWith(")")) {
            editText.setText(mathText + "×" + String.valueOf(number));

        } else {
            editText.setText(mathText + String.valueOf(number));
        }
    }
}