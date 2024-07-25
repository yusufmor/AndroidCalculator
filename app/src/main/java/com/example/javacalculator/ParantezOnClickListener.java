package com.example.javacalculator;

import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class ParantezOnClickListener implements View.OnClickListener{

    private final EditText editText;
    private final Queue<Parantez> parantezQueue;
    private final List<String> numbers = List.of("1" ,"2" , "3" ,"4"," 5" ,"6" ,"7" ,"8" ,"9" ,"0" , ")");
    private final List<String> semboles = List.of("+" ,"-" ,"%" ,"÷" , "×");


    public ParantezOnClickListener(EditText editText, Queue<Parantez> parantezQueue) {
        this.editText = editText;
        this.parantezQueue = parantezQueue;
    }

    @Override
    public void onClick(View v) {
        if (editText.getText().toString() == null) {
            editText.setText("");
        }
        String mathText = editText.getText().toString();

        for (String number :  numbers) {
            if (mathText.endsWith(number) && !parantezQueue.isEmpty() ) {
                editText.setText(mathText + ")");
                parantezQueue.remove();
                return;
            } else if (mathText.endsWith(number)) {
                editText.setText(mathText + "(");
                parantezQueue.add(new Parantez());
            }
        }

        for (String sembole : semboles) {
            if (mathText.endsWith(sembole)) {
                editText.setText(mathText + "(");
                parantezQueue.add(new Parantez());
            }
        }

    }
}
