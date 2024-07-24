package com.example.javacalculator;

import android.view.View;
import android.widget.EditText;

import java.util.List;

public class SemboleOnClickListener implements View.OnClickListener {

    private final String sembole;
    private final EditText editText;
    private final List<String> numbers = List.of("1" ,"2" , "3" ,"4"," 5" ,"6" ,"7" ,"8" ,"9" ,"0" ,")");

    public SemboleOnClickListener(String sembole, EditText editText) {
        this.sembole = sembole;
        this.editText = editText;
    }


    @Override
    public void onClick(View v) {

        if (editText.getText().toString() == null) {
            editText.setText("");
        }

        String mathText = editText.getText().toString();

        for (String number : numbers) {
            if (mathText.endsWith(number)) {
                editText.setText(
                        mathText + sembole
                );
                return;
            }
        }

    }
}
