package com.example.javacalculator;

import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOnClickListener implements View.OnClickListener {
    private final int number;
    private final EditText editText;
    private final List<String> semboles = Arrays.asList("+" , "-" ,"%" , "÷" ,"(" , ")" , "×");

    public NumberOnClickListener(int number_ , EditText editText_) {
        number = number_;
        editText = editText_;
    }

    @Override
    public void onClick(View v) {

        if (editText.getText().toString() == null) {
            editText.setText("");
        }

        Pattern pattern = Pattern.compile("([-+%÷×\\(\\)]0||^0$)$" ,  Pattern.UNICODE_CASE);
        String mathText = editText.getText().toString();
        Matcher m = pattern.matcher(mathText);



        System.out.println(mathText);
        boolean value  = m.find();
        System.out.println(value);
        String a = "";


        if (m.find() && mathText.length() > 0) {
            String format = mathText.substring(0, mathText.length() - 1) + Integer.toString(number);
            a = "if";
            editText.setText(
                    format
            );
            return;
        } else if (m.find()) {
            a = "elsif";
            editText.setText(
                    Integer.toString(number)
            );
            return;
        } else if (mathText.equals(")")) {
            editText.setText(
                    mathText + "×" + String.valueOf(number)
            );

        } else {
            a = "else";
            editText.setText(
                    mathText + Integer.toString(number)
            );
        }
        System.out.println(a);
    }
}