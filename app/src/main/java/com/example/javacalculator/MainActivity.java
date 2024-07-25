package com.example.javacalculator;

import android.os.Bundle;
import android.renderscript.Script;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.udojava.evalex.Expression;

import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.Queue;
public class MainActivity extends AppCompatActivity {


    private Button button_remove;
    private Button button_parantez;
    private Button button_yuzde;
    private Button button_bolme;
    private Button button_seven;
    private Button button_eight;
    private Button button_nine;
    private Button button_carp;
    private Button button_four;
    private Button button_five;
    private Button button_six;
    private Button button_eksi;
    private Button button_one;
    private Button button_two;
    private Button button_there;
    private Button button_plus;
    private Button button_negative;
    private Button button_zero;
    private Button button_virgul;
    private Button button_equals;

    private TextView editText;
    private Queue<Parantez> queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        queue = new LinkedList<>();

        button_remove = findViewById(R.id.button_remove);
        button_parantez = findViewById(R.id.button_parantez);
        button_yuzde = findViewById(R.id.button_yuzde);
        button_bolme = findViewById(R.id.button_bolme);
        button_seven = findViewById(R.id.button_seven);
        button_eight = findViewById(R.id.button_eight);
        button_nine = findViewById(R.id.button_nine);
        button_carp = findViewById(R.id.button_carp);
        button_four = findViewById(R.id.button_four);
        button_five = findViewById(R.id.button_five);
        button_six = findViewById(R.id.button_six);
        button_eksi = findViewById(R.id.button_eksi);
        button_one = findViewById(R.id.button_one);
        button_two = findViewById(R.id.button_two);
        button_there = findViewById(R.id.button_there);
        button_plus = findViewById(R.id.button_plus);
        button_negative = findViewById(R.id.button_negative);
        button_zero = findViewById(R.id.button_zero);
        button_virgul = findViewById(R.id.button_virgul);
        button_equals = findViewById(R.id.button_equals);

        editText = findViewById(R.id.textView);

        // Set number OnClickListener
        button_seven.setOnClickListener(new NumberOnClickListener("7", editText));
        button_eight.setOnClickListener(new NumberOnClickListener("8", editText));
        button_nine.setOnClickListener(new NumberOnClickListener("9", editText));
        button_four.setOnClickListener(new NumberOnClickListener("4", editText));
        button_five.setOnClickListener(new NumberOnClickListener("5", editText));
        button_six.setOnClickListener(new NumberOnClickListener("6", editText));
        button_one.setOnClickListener(new NumberOnClickListener("1", editText));
        button_two.setOnClickListener(new NumberOnClickListener("2", editText));
        button_there.setOnClickListener(new NumberOnClickListener("3", editText));
        button_zero.setOnClickListener(new NumberOnClickListener("0", editText));
        button_negative.setOnClickListener(new NumberOnClickListener("-", editText));

        // Set Sembole OnClickListener

        button_yuzde.setOnClickListener(new SemboleOnClickListener("%", editText));
        button_bolme.setOnClickListener(new SemboleOnClickListener("÷", editText));
        button_carp.setOnClickListener(new SemboleOnClickListener("×", editText));
        button_eksi.setOnClickListener(new SemboleOnClickListener("-", editText));
        button_plus.setOnClickListener(new SemboleOnClickListener("+", editText));


        // Others OnClickListeners

        button_parantez.setOnClickListener(new ParantezOnClickListener(editText, queue));
        button_remove.setOnClickListener(d -> {
            editText.setText("");
            queue.clear();
        });
        button_virgul.setOnClickListener(new DotOnClickListener(".", editText));

        button_equals.setOnClickListener(v -> {
            if (editText.getText().toString() == null) {
                editText.setText(null);
            }
            String mathText = editText.getText().toString();

            mathText = mathText.replace("×", "*");
            mathText = mathText.replace("÷", "/");
            try {

                Expression mathExpression = new Expression(mathText);
                String rs = mathExpression.eval().toString();
                editText.setText(rs);
            } catch (Exception ex) {
                editText.setText(null);
            }
        });
    }
}