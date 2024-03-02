package com.example.event;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultView;
    private EditText fieldNumber1, fieldNumber2;
    private Button calculateBtn;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        resultView = findViewById(R.id.result);
        fieldNumber1 = findViewById(R.id.filedNumber1);
        fieldNumber2 = findViewById(R.id.filedNumber2);
        calculateBtn = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
    }

    public void add(View view) {
        calculateBtn.setOnClickListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    double number1 = Double.parseDouble(fieldNumber1.getText().toString());
                    double number2 = Double.parseDouble(fieldNumber2.getText().toString());
                    String operator = spinner.getSelectedItem().toString();
                    String result = calculate(number1, number2, operator);
                    resultView.setText(result);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Nhap 2 so", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private String calculate(double x, double y, String p) {
        String s = "";
        switch (p) {
            case "+":
                s = "Sum: " + (x + y);
                break;
            case "-":
                s = "Minus: " + (x - y);
                break;
            case "*":
                s = "Multi: " + (x * y);
                break;
            case "/":
                if (y == 0) s = "No divide 0";
                else s = "Divide: " + (x / y);
                break;
        }
        return s;
    }

    @Override
    public void onClick(View v) {
        try {
            double number1 = Double.parseDouble(fieldNumber1.getText().toString());
            double number2 = Double.parseDouble(fieldNumber2.getText().toString());
            String result = calculate(number1, number2, "+");
            resultView.setText(result);
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Nhap 2 so", Toast.LENGTH_LONG).show();
        }
    }
}