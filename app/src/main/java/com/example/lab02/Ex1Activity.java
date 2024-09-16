package com.example.lab02;

import static java.lang.Math.random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Ex1Activity extends AppCompatActivity {

    EditText num1, num2;
    Button btn_click;
    TextView num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ex1);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = (TextView) findViewById(R.id.num3);
        btn_click = (Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer min = Integer.parseInt(num1.getText().toString());
                Integer max = Integer.parseInt(num2.getText().toString());
                Integer result = (int) (random() * (max - min + 1) + min);
                if(min > max){
                    num3.setText("Nhap lai di con");
                    return;
                }
                num3.setText(result.toString());
            }
        });
    }
}