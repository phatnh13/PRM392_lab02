package com.example.lab02;

import static java.lang.Math.random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Ex2Activity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView txt_result;
    private Button btn_plus, btn_minus, btn_multiple, btn_divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ex2);

        // Initialize views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        txt_result = findViewById(R.id.txt_result);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiple = findViewById(R.id.btn_multiple);
        btn_divide = findViewById(R.id.btn_divide);

        // Set onClickListeners for each button
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("-");
            }
        });

        btn_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("*");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("/");
            }
        });
    }

    private void calculateResult(String operator) {
        // Get input as strings from EditText fields
        String num1Str = num1.getText().toString();
        String num2Str = num2.getText().toString();

        // Handle empty input cases
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            txt_result.setText("M chua nhap so kia");
            return;
        }

        try {
            // Parse the input values to integers
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            int result = 0;

            // Use a switch case to call the correct operation function
            switch (operator) {
                case "+":
                    result = add(num1, num2);
                    txt_result.setText(String.valueOf(result));
                    break;
                case "-":
                    result = subtract(num1, num2);
                    txt_result.setText(String.valueOf(result));
                    break;
                case "*":
                    result = multiply(num1, num2);
                    txt_result.setText(String.valueOf(result));
                    break;
                case "/":
                    // Handle division separately here
                    if (num2 == 0) {
                        txt_result.setText("Lam gi chia duoc cho 0");
                    } else {
                        result = divide(num1, num2);
                        txt_result.setText(String.valueOf(result));
                    }
                    break;
                default:
                    txt_result.setText("Khong hieu nha");
            }

        } catch (NumberFormatException e) {
            txt_result.setText("Nhap sai r kia");
        }
    }

    // Function for addition
    private int add(int num1, int num2) {
        return num1 + num2;
    }

    // Function for subtraction
    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    // Function for multiplication
    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Function for division
    private int divide(int num1, int num2) {
        return num1 / num2;
    }
}