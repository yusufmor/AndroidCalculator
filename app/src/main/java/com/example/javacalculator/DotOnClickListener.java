package com.example.javacalculator;

import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class DotOnClickListener extends SemboleOnClickListener{

    private List<String> numbers = List.of("1" ,"2" , "3" ,"4"," 5" ,"6" ,"7" ,"8" ,"9" ,"0" );

    public DotOnClickListener(String sembole, TextView editText) {
        super(sembole, editText);
        super.numbers = numbers;
    }

}
