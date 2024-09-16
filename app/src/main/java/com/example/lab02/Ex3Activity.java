package com.example.lab02;

import static java.lang.Math.random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Ex3Activity extends AppCompatActivity implements View.OnClickListener {
    EditText userName;
    EditText password;
    TextView create;
    Button loginButton;

    private final String REQUIRE = "Required!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ex3);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        create = findViewById(R.id.create);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);
        create.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (userName.getText().toString().isEmpty()) {
            userName.setError(REQUIRE);
            return false;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError(REQUIRE);
            return false;
        }
        return true;
    }
    private void signIn(){
        if(!checkInput()){
            return;
        }
        Intent intent = new Intent(this, Ex1Activity.class);
        startActivity(intent);
        finish();
    }
    private void signUp(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loginButton) {
            signIn();
        } else if (view.getId() == R.id.create) {
            signUp();
        }
    }
}